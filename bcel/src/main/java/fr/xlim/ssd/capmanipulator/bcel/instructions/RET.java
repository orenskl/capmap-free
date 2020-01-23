package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class RET extends CapInstruction implements IndexedInstruction, TypedInstruction {

    int index;
    
    public RET(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.RET);
        index = byteArray.get(offSet + 1);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}