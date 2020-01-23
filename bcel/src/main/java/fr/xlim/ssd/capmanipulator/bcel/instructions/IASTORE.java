package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class IASTORE extends ArrayInstruction implements StackConsumer{

    public IASTORE(int offSet) {
        super(offSet, Constants.IASTORE);
    }
}