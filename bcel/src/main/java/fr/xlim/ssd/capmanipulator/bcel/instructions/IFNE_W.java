package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFNE_W extends IfInstruction {

    public IFNE_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFNE_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}