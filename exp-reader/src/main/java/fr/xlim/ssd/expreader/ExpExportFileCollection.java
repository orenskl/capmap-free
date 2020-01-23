package fr.xlim.ssd.expreader;

import java.io.IOException;
import java.util.ArrayList;

public class ExpExportFileCollection {
	ArrayList<ExpExportFile> exportFileCollection = new ArrayList<ExpExportFile>();

	public ExpExportFileCollection() {
	}

	public ExpExportFileCollection(ArrayList<ExpExportFile> exportFileCollection) {
		this.exportFileCollection = exportFileCollection;
	}

	public ArrayList<ExpExportFile> getExportFileCollection() {
		return exportFileCollection;
	}

	public void setExportFileCollection(ArrayList<ExpExportFile> exportFileCollection) {
		this.exportFileCollection = exportFileCollection;
	}

	public void addExportFile(ExpExportFile expFile) {
		this.exportFileCollection.add(expFile);
	}

	public void addExportFile(String path) throws IOException {
		this.exportFileCollection.add(new ExpExportFile(new ExpExportFileStream(path)));
	}

	public void addExportFile(ExpExportFileStream stream) throws IOException {
		this.exportFileCollection.add(new ExpExportFile(stream));
	}

	public ExpExportFile getExportFile(String pakageName) {
		for(ExpExportFile exportFile: this.exportFileCollection){
			if(exportFile.getThisPackageName().equals(pakageName))
				return exportFile;
		}
		return null;
	}

	public ExpExportFile getExportFile(byte[] packageAID) {
		for(ExpExportFile exportFile: this.exportFileCollection){

			byte[] internalAID = ((ExpConstantPackage) exportFile.getConstant_pool().get(exportFile.getThis_package())).getAid();
				if(compareAID(internalAID, packageAID))
					return exportFile;
		}
		return null;
	}

	private boolean compareAID(byte[] AID1, byte[] AID2){
		boolean result = true;

		if(AID1.length != AID2.length)
			return false;

		for(int i = 0; i < AID1.length; i++){
			if(AID1[i] != AID2[i])
				result = false;
		}

		return result;
	}
}
