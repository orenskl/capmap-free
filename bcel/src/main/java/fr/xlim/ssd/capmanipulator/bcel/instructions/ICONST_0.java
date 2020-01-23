package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ICONST_0 extends ConstInstruction {

    public ICONST_0(int offSet) {
        super(offSet, Constants.ICONST_0);
        setValue(0);
    }
}