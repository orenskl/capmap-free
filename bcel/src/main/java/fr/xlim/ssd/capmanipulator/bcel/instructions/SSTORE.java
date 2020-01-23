package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SSTORE extends StoreInstruction {

    public SSTORE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.SSTORE);
        index = byteArray.get(offSet + 1);
    }
}