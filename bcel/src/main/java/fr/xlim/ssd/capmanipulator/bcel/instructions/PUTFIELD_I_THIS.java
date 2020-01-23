package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_I_THIS extends FieldInstruction implements IndexedInstruction {

    public PUTFIELD_I_THIS(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_I_THIS);
        index = byteArray.get(offSet + 1);
    }
}