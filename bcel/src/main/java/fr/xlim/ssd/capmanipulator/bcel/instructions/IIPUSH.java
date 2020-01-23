package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class IIPUSH extends CapInstruction implements StackProducer {

    private int value;
    
    public IIPUSH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.IIPUSH);
        value = (byteArray.get(offSet + 1) << 24) | (byteArray.get(offSet + 2) << 16) | (byteArray.get(offSet + 3) << 8) | byteArray.get(offSet + 4);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}