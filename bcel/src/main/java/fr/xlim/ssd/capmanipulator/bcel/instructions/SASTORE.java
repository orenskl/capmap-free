package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class SASTORE extends ArrayInstruction implements StackConsumer {

    public SASTORE(int offSet) {
        super(offSet, Constants.SASTORE);
    }
}