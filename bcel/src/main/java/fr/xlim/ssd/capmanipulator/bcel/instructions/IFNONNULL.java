package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFNONNULL extends IfInstruction {

    public IFNONNULL(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFNONNULL);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}