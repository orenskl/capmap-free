package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ILOAD_0 extends LoadInstruction implements StackProducer {

    public ILOAD_0(int offSet) {
        super(offSet, Constants.ILOAD_0);
        index = 0;
    }
}