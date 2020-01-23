package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class GOTO extends GotoInstruction{

    public GOTO(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.GOTO);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}