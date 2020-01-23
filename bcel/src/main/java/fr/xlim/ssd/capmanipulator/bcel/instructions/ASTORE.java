package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ASTORE extends StoreInstruction {

    public ASTORE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.ASTORE);
        index = byteArray.get(offSet + 1);
    }
}