package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ILOAD_3 extends LoadInstruction implements StackProducer {

    public ILOAD_3(int offSet) {
        super(offSet, Constants.ILOAD_3);
        index = 3;
    }
}