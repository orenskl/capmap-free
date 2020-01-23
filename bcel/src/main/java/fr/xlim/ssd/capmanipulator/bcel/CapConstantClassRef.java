package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.utils.Tools;
import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.tool.Converter;
import fr.xlim.ssd.expreader.ExpExportFile;
import fr.xlim.ssd.expreader.ExpExportFileCollectionFactory;

import java.util.ArrayList;

public class CapConstantClassRef extends CapConstantPoolInfo {

	private ClassRef classRef;

	protected CapConstantClassRef(ConstantClassRef classRef) {
		super(ConstantPoolComponent.TAG_CLASS_REF);
		setClassRef(classRef.getClassRef());
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

	public ClassRef getClassRef() {
		return classRef;
	}

	public void setClassRef(ClassRef classRef) {
		this.classRef = classRef;
	}
}