package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class BSPUSH extends CapInstruction implements ConstantPushInstruction {

    int value;

    public BSPUSH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.BSPUSH);
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