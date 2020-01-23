package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.utils.Tools;
import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.tool.Converter;
import fr.xlim.ssd.expreader.ExpExportFile;
import fr.xlim.ssd.expreader.ExpExportFileCollectionFactory;

import java.util.ArrayList;

public class CapConstantVirtualMethodRef extends CapConstantPoolInfo {
	private ClassRef classRef;
	private byte token;

	public CapConstantVirtualMethodRef(ConstantVirtualMethodRef virtualMethodRef) throws UnableToReadCapFileException {
		super(ConstantPoolComponent.TAG_VIRTUAL_METHOD_REF);
		setClassRef(virtualMethodRef.getAssociatedClass());
		setToken(virtualMethodRef.getToken());
	}

	public String getClassName() throws Exception {
		if(classRef instanceof ExternalClassRef) {
			byte packageToken = (byte) (((ExternalClassRef) classRef).getPackageToken() & 0x7F);
			byte classToken = ((ExternalClassRef) classRef).getClassToken();


			ArrayList<Byte> listAID = CapFileFactory.getCapFile().getImportComponent().getPackages().get((int) packageToken).getAID();
			byte[] byteAID = Tools.List2Array(listAID);

			ExpExportFile exportFile= ExpExportFileCollectionFactory.getExpFile().getExportFile(byteAID);
			String className = exportFile.getClassName(classToken);

			return className;

		}
		if(classRef instanceof InternalClassRef) {
			short classIndex = ((InternalClassRef) classRef).getInternalClassRef();
			for (ClassDebugInfo classDebugInfo: CapFileFactory.getCapFile().getDebugComponent().getClasses()) {
				Utf8Info nameString;
				if (classIndex == (classDebugInfo.getLocation() - 3)) {
					nameString = CapFileFactory.getCapFile().getDebugComponent().getStringsTable().get((int) classDebugInfo.getNameIndex());
					return Converter.bytes2ascii(nameString.getBytes());
				}
			}
			throw new Exception("Class not found in the Debug Component");
		}
		throw new Exception("Error on the ClassRef");
	}

	public String getMethodName() throws Exception {
		if(classRef instanceof ExternalClassRef) {
			byte packageToken = (byte) (((ExternalClassRef) classRef).getPackageToken() & 0x7F);
			byte classToken = ((ExternalClassRef) classRef).getClassToken();

			ArrayList<Byte> listAID = CapFileFactory.getCapFile().getImportComponent().getPackages().get((int) packageToken).getAID();
			byte[] byteAID = Tools.List2Array(listAID);

			ExpExportFile exportFile= ExpExportFileCollectionFactory.getExpFile().getExportFile(byteAID);

			return exportFile.getMethodName(classToken, getToken());

		}
		if(classRef instanceof InternalClassRef) {
			short classOffset = ((InternalClassRef) classRef).getInternalClassRef();
			int classIndex = 0;
			for(int i = 0; i < CapFileFactory.getCapFile().getClassComponent().getInterfaces().size(); i++) {
				if(classOffset == CapFileFactory.getCapFile().getClassComponent().getInterfaces().get(i).getOffset())
					classIndex = i;
			}
			for(int i = 0; i < CapFileFactory.getCapFile().getClassComponent().getClasses().size(); i++) {
				if(classOffset == CapFileFactory.getCapFile().getClassComponent().getClasses().get(i).getOffset())
					classIndex = i + CapFileFactory.getCapFile().getClassComponent().getInterfaces().size();
			}

			int methodOffset = 0;
			for(int i = 0; i < CapFileFactory.getCapFile().getDescriptorComponent().getClasses().get(classIndex).getMethods().size(); i++) {
				if(CapFileFactory.getCapFile().getDescriptorComponent().getClasses().get(classIndex).getMethods().get(i).getToken() == getToken())
					methodOffset = CapFileFactory.getCapFile().getDescriptorComponent().getClasses().get(classIndex).getMethods().get(i).getMethodOffset();
			}

			for (ClassDebugInfo classDebugInfo: CapFileFactory.getCapFile().getDebugComponent().getClasses()) {
				if (classIndex == (classDebugInfo.getLocation() - 3)) {
					for(MethodDebugInfo methodDebugInfo: classDebugInfo.getMethods()){
						if(methodOffset == methodDebugInfo.getLocation() - 3){
							return Converter.bytes2ascii(CapFileFactory.getCapFile().getDebugComponent().getStringsTable().get(methodDebugInfo.getNameIndex()).getBytes());
						}
					}
				}
			}
			throw new Exception("Method not found in the Debug Component");
		}
		throw new Exception("Error on the ClassRef");
	}

	public ClassRef getClassRef() {
		return classRef;
	}

	public void setClassRef(ClassRef classRef) {
		this.classRef = classRef;
	}

	public byte getToken() {
		return token;
	}

	public void setToken(byte token) {
		this.token = token;
	}
}
