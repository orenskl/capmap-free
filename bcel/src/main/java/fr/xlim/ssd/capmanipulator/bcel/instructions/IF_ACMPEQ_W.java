package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_ACMPEQ_W extends IfInstruction {

    public IF_ACMPEQ_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_ACMPEQ_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}