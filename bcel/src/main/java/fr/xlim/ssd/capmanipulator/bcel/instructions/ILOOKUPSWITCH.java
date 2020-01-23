package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class ILOOKUPSWITCH extends Select {

    public ILOOKUPSWITCH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.ILOOKUPSWITCH);
        defaultJump = 0x0000FFFF & ((byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2));
        nbPairs =  (byteArray.get(offSet + 3) << 8 ) | byteArray.get(offSet + 4);
        length = 5 + nbPairs * 6;

        for(int i= 0; i<nbPairs; i++) {
            int matchByte = (byteArray.get(offSet + 5 + 6 * i) << 24 ) | (byteArray.get(offSet + 5 + 6 * i + 1) << 16) | (byteArray.get(offSet + 5 + 6 * i + 2) << 8 ) | byteArray.get(offSet + 5 + 6 * i + 3);
            int offSetByte = (byteArray.get(offSet + 5 + 6 * i + 4) << 8 ) | byteArray.get(offSet + 5 + 6 * i + 5);

            addPair(matchByte, offSetByte);
        }
    }
}