package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class InvokeInstruction extends FieldOrMehtod implements ExceptionThrower, StackConsumer, StackProducer {

    public InvokeInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }
}
