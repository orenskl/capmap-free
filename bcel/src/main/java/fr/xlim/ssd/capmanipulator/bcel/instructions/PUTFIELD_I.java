package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_I extends FieldInstruction implements IndexedInstruction {

    public PUTFIELD_I(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_I);
        index = byteArray.get(offSet + 1);
    }
}