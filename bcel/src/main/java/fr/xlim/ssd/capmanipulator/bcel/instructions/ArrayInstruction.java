package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class ArrayInstruction extends CapInstruction implements ExceptionThrower, TypedInstruction{

    public ArrayInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }
}
