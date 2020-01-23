package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_ACMPNE extends IfInstruction {

    public IF_ACMPNE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_ACMPNE);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}