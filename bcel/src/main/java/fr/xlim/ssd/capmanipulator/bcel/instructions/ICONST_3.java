package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ICONST_3 extends ConstInstruction {

    public ICONST_3(int offSet) {
        super(offSet, Constants.ICONST_3);
        setValue(3);
    }
}