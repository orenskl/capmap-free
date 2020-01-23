package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ACONST_NULL extends CapInstruction implements PushInstruction, TypedInstruction {

    public ACONST_NULL(int offSet) {
        super(offSet, Constants.ACONST_NULL);
    }
}