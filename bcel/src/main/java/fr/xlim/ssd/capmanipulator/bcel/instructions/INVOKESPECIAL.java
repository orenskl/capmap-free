package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class INVOKESPECIAL extends InvokeInstruction implements IndexedInstruction {

    public INVOKESPECIAL(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.INVOKESPECIAL);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}