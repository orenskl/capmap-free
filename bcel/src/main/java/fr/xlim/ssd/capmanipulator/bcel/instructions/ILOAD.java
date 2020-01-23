package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ILOAD extends LoadInstruction implements StackProducer {

    public ILOAD(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.ILOAD);
        index = byteArray.get(offSet + 1);
    }
}