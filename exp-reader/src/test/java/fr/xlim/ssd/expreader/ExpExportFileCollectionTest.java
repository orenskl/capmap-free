package fr.xlim.ssd.expreader;

import fr.xlim.ssd.capmanipulator.builder.FileManagement;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ExpExportFileCollectionTest {


	@Test
	public void testConstructor() throws IOException {
		ExpExportFileCollection expFileCollection = new ExpExportFileCollection();

		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacard/framework/javacard/framework.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacard/framework/service/javacard/service.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacard/security/javacard/security.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacardx/framework/util/intx/javacard/intx.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacardx/framework/util/javacard/util.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacardx/framework/tlv/javacard/tlv.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacardx/framework/math/javacard/math.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacardx/crypto/javacard/crypto.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacardx/biometry/javacard/biometry.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacardx/apdu/javacard/apdu.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/javacardx/external/javacard/external.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/java/io/javacard/io.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/java/lang/javacard/lang.exp");
		expFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.2.2/java/rmi/javacard/rmi.exp");


		assertEquals(expFileCollection.getExportFileCollection().size(), 14);

		assertEquals(expFileCollection.getExportFileCollection().get(0).getThisPackageName(), "javacard/framework");
		assertEquals(expFileCollection.getExportFileCollection().get(1).getThisPackageName(), "javacard/framework/service");
		assertEquals(expFileCollection.getExportFileCollection().get(2).getThisPackageName(), "javacard/security");
		assertEquals(expFileCollection.getExportFileCollection().get(3).getThisPackageName(), "javacardx/framework/util/intx");
		assertEquals(expFileCollection.getExportFileCollection().get(4).getThisPackageName(), "javacardx/framework/util");
		assertEquals(expFileCollection.getExportFileCollection().get(5).getThisPackageName(), "javacardx/framework/tlv");
		assertEquals(expFileCollection.getExportFileCollection().get(6).getThisPackageName(), "javacardx/framework/math");
		assertEquals(expFileCollection.getExportFileCollection().get(7).getThisPackageName(), "javacardx/crypto");
		assertEquals(expFileCollection.getExportFileCollection().get(8).getThisPackageName(), "javacardx/biometry");
		assertEquals(expFileCollection.getExportFileCollection().get(9).getThisPackageName(), "javacardx/apdu");
		assertEquals(expFileCollection.getExportFileCollection().get(10).getThisPackageName(), "javacardx/external");
		assertEquals(expFileCollection.getExportFileCollection().get(11).getThisPackageName(), "java/io");
		assertEquals(expFileCollection.getExportFileCollection().get(12).getThisPackageName(), "java/lang");
		assertEquals(expFileCollection.getExportFileCollection().get(13).getThisPackageName(), "java/rmi");

	}
}
