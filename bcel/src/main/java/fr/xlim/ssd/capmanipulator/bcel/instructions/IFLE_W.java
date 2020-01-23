package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFLE_W extends IfInstruction {

    public IFLE_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFLE_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}