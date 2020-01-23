package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFGE extends IfInstruction {

    public IFGE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFGE);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}