package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class AALOAD extends ArrayInstruction implements StackProducer {

    public AALOAD(int offSet) {
        super(offSet, Constants.AALOAD);
    }
}