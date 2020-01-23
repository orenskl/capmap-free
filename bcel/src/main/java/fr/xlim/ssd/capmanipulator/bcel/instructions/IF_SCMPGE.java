package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPGE extends IfInstruction {

    public IF_SCMPGE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPGE);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}