package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.utils.Tools;
import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.tool.Converter;
import fr.xlim.ssd.expreader.ExpExportFile;
import fr.xlim.ssd.expreader.ExpExportFileCollectionFactory;

import java.util.ArrayList;

public class CapConstantStaticFieldRef extends CapConstantPoolInfo {
	private StaticFieldRef fieldRef;

	public CapConstantStaticFieldRef(ConstantStaticFieldRef staticFieldRef) {
		super(ConstantPoolComponent.TAG_STATIC_FIELD_REF);
		setFieldRef(staticFieldRef.getStaticFieldRef());
	}

	public String getFieldName() throws Exception {
		if(fieldRef instanceof ExternalStaticFieldRef) {
			byte packageToken = (byte) (((ExternalStaticFieldRef) fieldRef).getPackageToken() & 0x7F);
			byte classToken = ((ExternalStaticFieldRef) fieldRef).getClassToken();
			byte fieldToken = ((ExternalStaticFieldRef) fieldRef).getToken();

			ArrayList<Byte> listAID = CapFileFactory.getCapFile().getImportComponent().getPackages().get((int) packageToken).getAID();
			byte[] byteAID = Tools.List2Array(listAID);

			ExpExportFile exportFile= ExpExportFileCollectionFactory.getExpFile().getExportFile(byteAID);

			return exportFile.getFieldName(classToken, fieldToken);

		}


		if(fieldRef instanceof InternalStaticFieldRef) {
			short fiedlOffset = ((InternalStaticFieldRef) fieldRef).getOffset();

			for (ClassDebugInfo classDebugInfo: CapFileFactory.getCapFile().getDebugComponent().getClasses()) {
					for(FieldDebugInfo fieldDebugInfo: classDebugInfo.getFields()){
						if(((fieldDebugInfo.getAccessFlags() & FieldDebugInfo.ACC_FINAL) == 0 && (fieldDebugInfo.getAccessFlags() & FieldDebugInfo.ACC_STATIC) != 0) ||
							((fieldDebugInfo.getAccessFlags() & FieldDebugInfo.ACC_FINAL) != 0 && (fieldDebugInfo.getAccessFlags() & FieldDebugInfo.ACC_STATIC) != 0 &&
									CapFileFactory.getCapFile().getDebugComponent().getStringsTable().get(fieldDebugInfo.getDescriptorIndex()).getBytes().get(0) == 0x5B)) {
							if(fieldDebugInfo.getContents() == fiedlOffset){
								return Converter.bytes2ascii(CapFileFactory.getCapFile().getDebugComponent().getStringsTable().get(fieldDebugInfo.getNameIndex()).getBytes());
							}
						}
					}
			}
			throw new Exception("Field not found in the Debug Component");
		}
		throw new Exception("Error on the ClassRef");
	}

	public StaticFieldRef getFieldRef() {
		return fieldRef;
	}

	public void setFieldRef(StaticFieldRef fieldRef) {
		this.fieldRef = fieldRef;
	}
}
