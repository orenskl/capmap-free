package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SLOAD_3 extends LoadInstruction {

    public SLOAD_3(int offSet) {
        super(offSet, Constants.SLOAD_3);
        index = 3;
    }
}