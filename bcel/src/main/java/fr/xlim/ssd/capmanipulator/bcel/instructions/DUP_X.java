package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class DUP_X extends StackInstruction {

    private byte mn;

    public DUP_X(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.DUP_X);
        mn = byteArray.get(offSet + 1);
    }

    public byte getMn() {
        return mn;
    }

    public void setMn(byte mn) {
        this.mn = mn;
    }
}