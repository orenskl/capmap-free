package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class ReturnInstruction extends CapInstruction implements ExceptionThrower, TypedInstruction, StackConsumer {

    public ReturnInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }
}
