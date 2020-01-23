package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ILOAD_2 extends LoadInstruction implements StackProducer {

    public ILOAD_2(int offSet) {
        super(offSet, Constants.ILOAD_2);
        index = 2;
    }
}