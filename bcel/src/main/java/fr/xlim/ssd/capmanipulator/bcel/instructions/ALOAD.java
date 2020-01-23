package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ALOAD extends LoadInstruction {

    public ALOAD(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.ALOAD);
        index = byteArray.get(offSet + 1);
    }
}