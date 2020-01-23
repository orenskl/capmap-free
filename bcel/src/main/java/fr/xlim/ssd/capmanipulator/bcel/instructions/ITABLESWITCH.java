package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ITABLESWITCH  extends Select {

    private int lowByte;
    private int highByte;
    
    public ITABLESWITCH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.ITABLESWITCH);
        defaultJump = 0x0000FFFF & ((byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2));
        lowByte = (byteArray.get(offSet + 3) << 24) | (byteArray.get(offSet + 4) << 16) | (byteArray.get(offSet + 5) << 8) | byteArray.get(offSet + 6);
        highByte = (byteArray.get(offSet + 7) << 24) | (byteArray.get(offSet + 8) << 16) | (byteArray.get(offSet + 9) << 8) | byteArray.get(offSet + 10);
        nbPairs = highByte - lowByte + 1;
        for(int i=0; i<nbPairs; i++) {
            addPair(lowByte + i, (byteArray.get(offSet + 11 + i * 2) << 8 ) | byteArray.get(offSet + 11 + i*2 + 1));
        }

		length = 11 + 2*nbPairs;
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