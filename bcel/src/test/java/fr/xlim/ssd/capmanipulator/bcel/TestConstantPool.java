package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.exceptions.CapFieldException;
import fr.xlim.ssd.capmanipulator.builder.CompilationHelper;
import fr.xlim.ssd.capmanipulator.builder.FileManagement;
import fr.xlim.ssd.capmanipulator.builder.JavaCardVersion;
import fr.xlim.ssd.capmanipulator.builder.ProjectConfiguration;
import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.expreader.ExpExportFileCollection;
import fr.xlim.ssd.expreader.ExpExportFileCollectionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestConstantPool {

	private CompilationHelper helper;

	@Before
	public void buildTestbed() {
		ProjectConfiguration configuration = new ProjectConfiguration(
				//new File(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/testbeds/testbed004/"),
				//new File(FileManagement.getModuleRoot().getAbsolutePath() + File.separator + "target/testbed004/")
				new File(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/testbeds/fuzzingApplet/"),
				new File(FileManagement.getModuleRoot().getAbsolutePath() + File.separator + "target/fuzzingApplet/")
		);

		helper = new CompilationHelper(configuration, JavaCardVersion.VERSION_2_1_2, true);
		helper.build();
	}


	@Test
	public void testApplet004() throws Exception, CapFieldException {
		Map map1 = (Map) helper.getConfiguration().get("results");
		Map map2 = (Map) map1.get("cap");

		//Load CapFile
		CapFileFactory.loadCapFile(map2.get("file").toString());

		//Load ExportFile
		ExpExportFileCollection exportFileCollection = new ExpExportFileCollection();
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacard/framework/javacard/framework.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacard/framework/service/javacard/service.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacard/security/javacard/security.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacardx/framework/util/intx/javacard/intx.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacardx/framework/util/javacard/util.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacardx/framework/tlv/javacard/tlv.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacardx/framework/math/javacard/math.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacardx/crypto/javacard/crypto.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacardx/biometry/javacard/biometry.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacardx/apdu/javacard/apdu.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/javacardx/external/javacard/external.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/java/io/javacard/io.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/java/lang/javacard/lang.exp");
		exportFileCollection.addExportFile(FileManagement.getProjectRoot().getAbsolutePath() + File.separator + "various/api_export_files_2.1/java/rmi/javacard/rmi.exp");
		ExpExportFileCollectionFactory.loadExpFile(exportFileCollection);


		CapConstantPool	constantPool = new CapConstantPool();

		assertEquals(CapFileFactory.getCapFile().getConstantPoolComponent().getConstantPool().size(), constantPool.ConstantPool.size());

		for(int i=0; i<constantPool.ConstantPool.size(); i++) {
			ConstantPoolInfo constantPoolInfo = CapFileFactory.getCapFile().getConstantPoolComponent().getConstantPool().get(i);

			if(constantPoolInfo instanceof ConstantClassRef){
				assertEquals(constantPool.getCPConstant(i) instanceof CapConstantClassRef, true);
				assertEquals(((CapConstantClassRef) constantPool.getCPConstant(i)).getClassRef(), ((ConstantClassRef) constantPoolInfo).getClassRef());
			}
			if(constantPoolInfo instanceof ConstantInstanceFieldRef){
				assertEquals(constantPool.getCPConstant(i) instanceof CapConstantInstanceFieldRef, true);
				assertEquals(((CapConstantInstanceFieldRef)constantPool.getCPConstant(i)).getClassRef(), ((ConstantInstanceFieldRef) constantPoolInfo).getAssociatedClass());
			}
			if(constantPoolInfo instanceof ConstantStaticFieldRef){
				assertEquals(constantPool.getCPConstant(i) instanceof CapConstantStaticFieldRef, true);
				assertEquals(((CapConstantStaticFieldRef)constantPool.getCPConstant(i)).getFieldRef(), ((ConstantStaticFieldRef) constantPoolInfo).getStaticFieldRef());
			}
			if(constantPoolInfo instanceof ConstantStaticMethodRef){
				assertEquals(constantPool.getCPConstant(i) instanceof CapConstantStaticMethodRef, true);
				assertEquals(((CapConstantStaticMethodRef)constantPool.getCPConstant(i)).getMethodRef(), ((ConstantStaticMethodRef) constantPoolInfo).getStaticMethodRef());
			}
			if(constantPoolInfo instanceof ConstantSuperMethodRef){
				assertEquals(constantPool.getCPConstant(i) instanceof CapConstantSuperMethodRef, true);
				assertEquals(((CapConstantSuperMethodRef)constantPool.getCPConstant(i)).getClassRef(), ((ConstantSuperMethodRef) constantPoolInfo).getAssociatedClass());
			}
			if(constantPoolInfo instanceof ConstantVirtualMethodRef){
				assertEquals(constantPool.getCPConstant(i) instanceof CapConstantVirtualMethodRef, true);
				assertEquals(((CapConstantVirtualMethodRef)constantPool.getCPConstant(i)).getClassRef(), ((ConstantVirtualMethodRef) constantPoolInfo).getAssociatedClass());

			}
		}
	}
}
