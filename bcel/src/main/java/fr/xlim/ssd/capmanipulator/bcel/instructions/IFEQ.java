package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IFEQ extends IfInstruction {

    public IFEQ(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IFEQ);
        jumpOffSet = byteArray.get(offSet + 1);
    }
}