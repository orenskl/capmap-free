package fr.xlim.ssd.expreader;

import java.io.IOException;

public class ExpExportFileCollectionFactory {

	private static ExpExportFileCollection expFileCollection;

	public static void loadExpFile(ExpExportFileCollection FileCollection) throws IOException {
		expFileCollection = FileCollection;
	}

	public static ExpExportFileCollection getExpFile() {
		return expFileCollection;
	}
}
