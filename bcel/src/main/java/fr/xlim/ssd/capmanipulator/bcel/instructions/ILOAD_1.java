package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ILOAD_1 extends LoadInstruction implements StackProducer {

    public ILOAD_1(int offSet) {
        super(offSet, Constants.ILOAD_1);
        index = 1;
    }
}