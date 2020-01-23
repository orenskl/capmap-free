package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class POP2 extends StackInstruction implements PopInstruction {

    public POP2(int offSet) {
        super(offSet, Constants.POP2);
    }
}