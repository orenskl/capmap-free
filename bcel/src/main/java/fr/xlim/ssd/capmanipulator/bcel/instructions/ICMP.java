package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ICMP extends CapInstruction implements StackConsumer, StackProducer {

    public ICMP(int offSet) {
        super(offSet, Constants.ICMP);
    }
}