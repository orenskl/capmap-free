package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ICONST_4 extends ConstInstruction {

    public ICONST_4(int offSet) {
        super(offSet, Constants.ICONST_4);
        setValue(4);
    }
}