package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ICONST_M1 extends ConstInstruction {

    public ICONST_M1(int offSet) {
        super(offSet, Constants.ICONST_M1);
        setValue(-1);
    }
}