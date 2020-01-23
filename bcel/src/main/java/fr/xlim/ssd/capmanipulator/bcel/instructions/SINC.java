package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SINC extends LocalVariableInstruction {


    private byte constant;

    public SINC(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.SINC);
        index = byteArray.get(offSet + 1);
        constant = byteArray.get(offSet + 2);
    }

    public byte getConstant() {
        return constant;
    }

    public void setConstant(byte constant) {
        this.constant = constant;
    }
}