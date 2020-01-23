package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GOTO_W extends GotoInstruction {

    public GOTO_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GOTO_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}