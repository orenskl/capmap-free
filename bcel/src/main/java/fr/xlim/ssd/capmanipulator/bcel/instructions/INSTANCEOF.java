package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class INSTANCEOF extends CPInstruction implements LoadClass, ExceptionThrower, StackProducer, StackConsumer {

    private byte aType;

    public INSTANCEOF(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.INSTANCEOF);
        aType = byteArray.get(offSet + 1);
        index = (byteArray.get(offSet + 2) << 8) | byteArray.get(offSet + 3);
    }

    public byte getaType() {
        return aType;
    }

    public void setaType(byte aType) {
        this.aType = aType;
    }
}