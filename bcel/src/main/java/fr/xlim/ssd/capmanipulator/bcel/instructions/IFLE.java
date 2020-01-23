package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFLE extends IfInstruction {

    public IFLE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFLE);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}