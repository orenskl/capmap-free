package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class SLOOKUPSWITCH extends Select {

    public SLOOKUPSWITCH(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.SLOOKUPSWITCH);
        defaultJump = 0x0000FFFF & ((byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2));
        nbPairs =  (byteArray.get(offSet + 3) << 8 ) | byteArray.get(offSet + 4);
        length = 5 + nbPairs * 4;

        for(int i= 0; i<nbPairs; i++) {
            int matchByte = (byteArray.get(offSet + 5 + 4 * i) << 8 ) | byteArray.get(offSet + 5 + 4 * i + 1);
            int offSetByte = (byteArray.get(offSet + 5 + 4 * i + 2) << 8 ) | byteArray.get(offSet + 5 + 4 * i + 3);

            addPair(matchByte, offSetByte);
        }
    }
}