package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class INVOKESTATIC extends InvokeInstruction implements IndexedInstruction {

    public INVOKESTATIC(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.INVOKESTATIC);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}