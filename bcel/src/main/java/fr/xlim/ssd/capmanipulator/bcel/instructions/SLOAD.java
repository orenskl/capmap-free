package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SLOAD extends LoadInstruction {

    public SLOAD(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.SLOAD);
        index = byteArray.get(offSet + 1);
    }
}