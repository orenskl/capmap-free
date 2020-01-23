package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class BASTORE extends ArrayInstruction implements StackConsumer {

    public BASTORE(int offSet) {
        super(offSet, Constants.BASTORE);
    }
}