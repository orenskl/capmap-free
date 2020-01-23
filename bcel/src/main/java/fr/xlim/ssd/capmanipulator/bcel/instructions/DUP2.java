package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class DUP2 extends StackInstruction implements PushInstruction {

    public DUP2(int offSet) {
        super(offSet, Constants.DUP2);
    }
}