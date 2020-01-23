package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SSPUSH extends StoreInstruction {

    public SSPUSH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.SSPUSH);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}