package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class BIPUSH extends CapInstruction implements ConstantPushInstruction {

    int value;

    public BIPUSH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.BIPUSH);
        value = byteArray.get(offSet + 1);
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