package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPGE_W extends IfInstruction {

    public IF_SCMPGE_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPGE_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}