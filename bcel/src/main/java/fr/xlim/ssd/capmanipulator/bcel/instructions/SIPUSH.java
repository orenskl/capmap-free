package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SIPUSH extends CapInstruction implements ConstantPushInstruction {

    int value;


    public SIPUSH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.SIPUSH);
        value = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}