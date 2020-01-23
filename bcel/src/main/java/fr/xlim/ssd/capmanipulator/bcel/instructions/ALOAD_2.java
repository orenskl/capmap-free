package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ALOAD_2 extends LoadInstruction {

    public ALOAD_2(int offSet) {
        super(offSet, Constants.ALOAD_2);
        index = 2;
    }
}