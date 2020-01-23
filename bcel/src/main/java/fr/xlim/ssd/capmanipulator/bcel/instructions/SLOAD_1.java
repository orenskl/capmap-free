package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SLOAD_1 extends LoadInstruction {

    public SLOAD_1(int offSet) {
        super(offSet, Constants.SLOAD_1);
        index = 1;
    }
}