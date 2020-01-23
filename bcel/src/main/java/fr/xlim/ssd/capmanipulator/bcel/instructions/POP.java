package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class POP extends StackInstruction implements PopInstruction {

    public POP(int offSet) {
        super(offSet, Constants.POP);
    }
}