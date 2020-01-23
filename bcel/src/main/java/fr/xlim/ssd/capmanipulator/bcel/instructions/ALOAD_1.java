package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ALOAD_1 extends LoadInstruction {

    public ALOAD_1(int offSet) {
        super(offSet, Constants.ALOAD_1);
        index = 1;
    }
}