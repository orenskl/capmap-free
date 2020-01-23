package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFNONNULL_W extends IfInstruction {

    public IFNONNULL_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFNONNULL_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}