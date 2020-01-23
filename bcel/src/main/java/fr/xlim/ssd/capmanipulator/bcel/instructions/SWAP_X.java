package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SWAP_X extends StackInstruction implements StackConsumer, StackProducer {

    private byte mn;

    public SWAP_X(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.SWAP_X);
        mn = byteArray.get(offSet + 1);
    }

    public byte getMn() {
        return mn;
    }

    public void setMn(byte mn) {
        this.mn = mn;
    }
}