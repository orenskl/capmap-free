package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.exceptions.CapFieldException;
import fr.xlim.ssd.capmanipulator.library.*;

import java.util.ArrayList;
import java.util.List;

public class CapParser {

    private List<CapInterface> capInterfaces;
    private List<CapClass> capClasses;
    private List<CapField> capFields;
	private CapConstantPool capConstantPool;

    public CapParser() throws Exception {
        loadClasses();
        loadInterfaces();
		loadConstantPool();
    }

	private void loadConstantPool() throws Exception {
		capConstantPool = new CapConstantPool();
	}

	private void loadClasses() {

        capClasses = new ArrayList<CapClass>();

        for (ClassDescriptorInfo classDescriptorInfo : CapFileFactory.getCapFile().getDescriptorComponent().getClasses()) {

            capClasses.add(new CapClass(classDescriptorInfo));
        }
    }

    private void loadInterfaces() {

        capInterfaces = new ArrayList<CapInterface>();

        for (InterfaceInfo interfaceInfo : CapFileFactory.getCapFile().getClassComponent().getInterfaces()){

            capInterfaces.add(new CapInterface(interfaceInfo));
        }
    }
    
    private void loadFields(CapFile capFile) {
        
        capFields = new ArrayList<CapField>();
        
        for (ClassDescriptorInfo classDescriptorInfo : capFile.getDescriptorComponent().getClasses()) {

            for (FieldDescriptorInfo fieldDescriptorInfo : classDescriptorInfo.getFields()) {
                
                capFields.add(new CapField(classDescriptorInfo, fieldDescriptorInfo));
            }
        }
        
    }

	public CapConstantPool getCapConstantPool() {
		return capConstantPool;
	}

	public List<CapInterface> getCapInterfaces() {
        return capInterfaces;
    }

    public List<CapClass> getCapClasses() {
        return capClasses;
    }

    public void print() throws CapFieldException {

        for (CapClass capClass : capClasses) {
             capClass.print();
        }

        System.out.println("=======================================");
        System.out.println("---------------------------------------");
        System.out.println("=======================================");
    }
}
