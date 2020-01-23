package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class AASTORE extends ArrayInstruction implements StackConsumer{

    public AASTORE(int offSet) {
        super(offSet, Constants.AASTORE);
    }
}