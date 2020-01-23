package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPLT extends IfInstruction {

    public IF_SCMPLT(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPLT);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}