package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ICONST_2 extends ConstInstruction {

    public ICONST_2(int offSet) {
        super(offSet, Constants.ICONST_2);
        setValue(2);
    }
}