package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ICONST_1 extends ConstInstruction {

    public ICONST_1(int offSet) {
        super(offSet, Constants.ICONST_1);
        setValue(1);
    }
}