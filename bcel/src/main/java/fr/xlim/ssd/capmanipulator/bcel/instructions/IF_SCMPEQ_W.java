package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPEQ_W extends IfInstruction {

    public IF_SCMPEQ_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPEQ_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}