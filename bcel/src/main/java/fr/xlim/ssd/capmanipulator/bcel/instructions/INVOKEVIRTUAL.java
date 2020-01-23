package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class INVOKEVIRTUAL extends InvokeInstruction implements IndexedInstruction {

    public INVOKEVIRTUAL(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.INVOKEVIRTUAL);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}