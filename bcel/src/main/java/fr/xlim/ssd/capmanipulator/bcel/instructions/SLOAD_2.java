package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SLOAD_2 extends LoadInstruction {

    public SLOAD_2(int offSet) {
        super(offSet, Constants.SLOAD_2);
        index = 2;
    }
}