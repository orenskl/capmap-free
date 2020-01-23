package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class ConversionInstruction extends CapInstruction implements TypedInstruction, StackProducer, StackConsumer {

    public ConversionInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }
}
