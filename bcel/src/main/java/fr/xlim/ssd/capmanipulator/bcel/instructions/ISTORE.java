package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ISTORE extends StoreInstruction {

    public ISTORE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.ISTORE);
        index = byteArray.get(offSet + 1);
    }
}