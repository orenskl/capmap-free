package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFLT extends IfInstruction {

    public IFLT(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFLT);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}