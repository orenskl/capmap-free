package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class DUP extends StackInstruction implements PushInstruction {

    public DUP(int offSet) {
        super(offSet, Constants.DUP);
    }
}