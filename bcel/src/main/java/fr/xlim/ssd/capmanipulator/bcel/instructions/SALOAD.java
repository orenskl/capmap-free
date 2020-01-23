package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class SALOAD extends ArrayInstruction implements StackProducer {

    public SALOAD(int offSet) {
        super(offSet, Constants.SALOAD);
    }
}