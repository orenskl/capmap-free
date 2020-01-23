package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPEQ extends IfInstruction {

    public IF_SCMPEQ(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPEQ);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}