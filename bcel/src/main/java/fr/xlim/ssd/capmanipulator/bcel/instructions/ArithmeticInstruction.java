package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class ArithmeticInstruction extends CapInstruction implements TypedInstruction, StackProducer, StackConsumer{

    public ArithmeticInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }
}
