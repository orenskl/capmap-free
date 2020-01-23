package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ALOAD_3 extends LoadInstruction {

    public ALOAD_3(int offSet) {
        super(offSet, Constants.ALOAD_3);
        index = 3;
    }
}