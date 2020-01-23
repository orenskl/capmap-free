package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SINC_W extends LocalVariableInstruction {

    private int constant;

    public SINC_W(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.SINC_W);
        index = byteArray.get(offSet + 1);
        constant = (byteArray.get(offSet + 2) << 8) | byteArray.get(offSet + 3);
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }
}