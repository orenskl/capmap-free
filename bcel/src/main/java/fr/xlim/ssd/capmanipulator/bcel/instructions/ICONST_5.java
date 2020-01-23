package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ICONST_5 extends ConstInstruction {

    public ICONST_5(int offSet) {
        super(offSet, Constants.ICONST_5);
        setValue(5);
    }
}