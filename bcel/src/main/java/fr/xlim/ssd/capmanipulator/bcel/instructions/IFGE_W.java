package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFGE_W extends IfInstruction {

    public IFGE_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFGE_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}