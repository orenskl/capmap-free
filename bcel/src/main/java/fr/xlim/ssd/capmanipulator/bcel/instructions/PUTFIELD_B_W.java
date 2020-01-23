package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class PUTFIELD_B_W extends FieldInstruction implements ExceptionThrower, PopInstruction {

    public PUTFIELD_B_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.PUTFIELD_B_W);
        index = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}