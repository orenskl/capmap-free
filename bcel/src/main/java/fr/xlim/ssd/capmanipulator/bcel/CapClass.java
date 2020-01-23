package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.exceptions.CapFieldException;
import fr.xlim.ssd.capmanipulator.library.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CapClass extends CapClassOrInterface {

    private List<CapMethod> methods;
    private List<ClassRef> extendedInterfaces;
    private ClassDescriptorInfo classDescriptorInfo;
    private ArrayList<CapField> capFields;

    public CapClass(ClassDescriptorInfo classDescriptorInfo) {
        methods = new LinkedList<CapMethod>();
        extendedInterfaces = classDescriptorInfo.getInterfaces();
        this.classDescriptorInfo = classDescriptorInfo;

        for (int i = 0; i < classDescriptorInfo.getMethodCount(); i++) {

            methods.add(new CapMethod(classDescriptorInfo, classDescriptorInfo.getMethods().get(i) ,i));
        }

        capFields = new ArrayList<CapField>();

        for (FieldDescriptorInfo fieldDescriptorInfo : classDescriptorInfo.getFields()){

            capFields.add(new CapField(classDescriptorInfo, fieldDescriptorInfo));
        }
    }


    public List getExtendedInterfaces(){

        return extendedInterfaces;
    }

    public List<CapMethod> getMethods() {
        return methods;
    }

    public ClassDescriptorInfo getClassDescriptorInfo() {
        return classDescriptorInfo;
    }

    public ArrayList<CapField> getCapFields() {
        return capFields;
    }

    public void print() throws CapFieldException {

        System.out.println("======================================");
        System.out.println("| Class token #" + classDescriptorInfo.getToken());
        System.out.println("======================================");
        System.out.println();

        for (CapMethod capMethod : methods) {
            //capMethod.print();
        }

        for (CapField capField : capFields) {
            System.out.println("");
            System.out.print("| Field: ");
            capField.print();
            System.out.println("--------------------------------");
        }
    }
}
