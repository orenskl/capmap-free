package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ARRAYLENGTH extends CapInstruction implements ExceptionThrower, StackProducer, StackConsumer{

    public ARRAYLENGTH(int offSet) {
        super(offSet, Constants.ARRAYLENGTH);
    }
}