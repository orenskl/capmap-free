package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPNE extends IfInstruction {

    public IF_SCMPNE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPNE);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}