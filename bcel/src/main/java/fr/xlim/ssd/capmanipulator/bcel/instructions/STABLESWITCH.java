package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class STABLESWITCH extends Select {

    private int lowByte;
    private int highByte;

    public STABLESWITCH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.STABLESWITCH);
        defaultJump = 0x0000FFFF & ((byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2));
        lowByte = (byteArray.get(offSet + 3) << 8) | byteArray.get(offSet + 4);
        highByte = (byteArray.get(offSet + 5) << 8) | byteArray.get(offSet + 6);
        nbPairs = highByte - lowByte + 1;
        for(int i=0; i<nbPairs; i++) {
            addPair(lowByte + i, (byteArray.get(offSet + 7 + i * 2) << 8 ) | byteArray.get(offSet + 7 + i*2 + 1));
        }
		length = 7 + 2*nbPairs;
    }

    public int getLowByte() {
        return lowByte;
    }

    public void setLowByte(int lowByte) {
        this.lowByte = lowByte;
    }

    public int getHighByte() {
        return highByte;
    }

    public void setHighByte(int highByte) {
        this.highByte = highByte;
    }
}