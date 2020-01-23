package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPGT extends IfInstruction {

    public IF_SCMPGT(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPGT);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}