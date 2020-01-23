package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class NEWARRAY extends CapInstruction implements AllocationInstruction, ExceptionThrower, StackProducer {

    private byte aType;

    public NEWARRAY(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.NEWARRAY);
        aType = byteArray.get(offSet + 1);
    }

    public byte getaType() {
        return aType;
    }

    public void setaType(byte aType) {
        this.aType = aType;
    }
}