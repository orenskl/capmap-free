package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IF_SCMPLT_W extends IfInstruction {

    public IF_SCMPLT_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IF_SCMPLT_W);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}