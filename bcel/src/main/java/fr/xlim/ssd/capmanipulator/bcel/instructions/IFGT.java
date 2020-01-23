package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFGT extends IfInstruction {

    public IFGT(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFGT);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}