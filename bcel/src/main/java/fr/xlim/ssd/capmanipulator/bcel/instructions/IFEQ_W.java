package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFEQ_W extends IfInstruction {

    public IFEQ_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFEQ_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}