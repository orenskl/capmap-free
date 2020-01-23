package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class BALOAD extends ArrayInstruction implements StackProducer {

    public BALOAD(int offSet) {
        super(offSet, Constants.BALOAD);
    }
}