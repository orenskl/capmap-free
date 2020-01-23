package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.utils.Tools;
import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.tool.Converter;
import fr.xlim.ssd.expreader.ExpExportFile;
import fr.xlim.ssd.expreader.ExpExportFileCollectionFactory;

import java.util.ArrayList;

public class CapConstantStaticMethodRef extends CapConstantPoolInfo {
	private StaticMethodRef methodRef;

	public CapConstantStaticMethodRef(ConstantStaticMethodRef staticMethodRef) {
		super(ConstantPoolComponent.TAG_STATIC_METHOD_REF);
		setMethodRef(staticMethodRef.getStaticMethodRef());
	}

	public String getMethodName() throws Exception {
		if(methodRef instanceof ExternalStaticMethodRef) {
			byte packageToken = (byte) (((ExternalStaticMethodRef) methodRef).getPackageToken() & 0x7F);
			byte classToken = ((ExternalStaticMethodRef) methodRef).getClassToken();
			byte methodToken = ((ExternalStaticMethodRef) methodRef).getToken();

			ArrayList<Byte> listAID = CapFileFactory.getCapFile().getImportComponent().getPackages().get((int) packageToken).getAID();
			byte[] byteAID = Tools.List2Array(listAID);

			ExpExportFile exportFile = ExpExportFileCollectionFactory.getExpFile().getExportFile(byteAID);

			return exportFile.getMethodName(classToken, methodToken);

		}
		if(methodRef instanceof InternalStaticMethodRef) {
			short methodOffset = ((InternalStaticMethodRef) methodRef).getOffset();

			for (ClassDebugInfo classDebugInfo: CapFileFactory.getCapFile().getDebugComponent().getClasses()) {
				for(MethodDebugInfo methodDebugInfo: classDebugInfo.getMethods()){
					if(methodOffset == methodDebugInfo.getLocation() - 3){
						return Converter.bytes2ascii(CapFileFactory.getCapFile().getDebugComponent().getStringsTable().get(methodDebugInfo.getNameIndex()).getBytes());
					}
				}
			}
			throw new Exception("Method not found in the Debug Component");
		}
		throw new Exception("Error on the ClassRef");
	}

	public StaticMethodRef getMethodRef() {
		return methodRef;
	}

	public void setMethodRef(StaticMethodRef methodRef) {
		this.methodRef = methodRef;
	}
}
