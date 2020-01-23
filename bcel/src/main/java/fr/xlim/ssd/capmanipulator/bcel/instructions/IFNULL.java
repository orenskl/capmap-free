package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFNULL extends IfInstruction {

    public IFNULL(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFNULL);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}