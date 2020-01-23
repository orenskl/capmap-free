package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFLT_W extends IfInstruction {

    public IFLT_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFLT_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}