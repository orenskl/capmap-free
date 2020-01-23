package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPLE extends IfInstruction {

    public IF_SCMPLE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPLE);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}