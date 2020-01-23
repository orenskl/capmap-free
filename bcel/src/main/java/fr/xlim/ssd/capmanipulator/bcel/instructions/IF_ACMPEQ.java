package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_ACMPEQ extends IfInstruction {

    public IF_ACMPEQ(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_ACMPEQ);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}