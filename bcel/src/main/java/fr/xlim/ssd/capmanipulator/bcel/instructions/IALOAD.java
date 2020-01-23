package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class IALOAD extends ArrayInstruction implements StackProducer {

    public IALOAD(int offSet) {
        super(offSet, Constants.IALOAD);
    }
}