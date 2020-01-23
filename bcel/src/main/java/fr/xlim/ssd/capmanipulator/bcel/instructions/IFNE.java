package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFNE extends IfInstruction {

    public IFNE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFNE);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}