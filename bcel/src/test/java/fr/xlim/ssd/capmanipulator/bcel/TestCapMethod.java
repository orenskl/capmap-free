package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.bcel.instructions.Constants;
import fr.xlim.ssd.capmanipulator.library.MethodInfo;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TestCapMethod {


    Logger logger = LoggerFactory.getLogger("fr.xlim.ssd.capmanipulator.bcel.TestCapMethod");


    @Test
    public void testBuildInstructionsList() throws Exception {


        CapMethod capMethod = new CapMethod();
        MethodInfo methodInfo = new MethodInfo();

        ArrayList<Byte> byteCodes = new ArrayList<Byte>();

        for (short i = 0; i < 0xB9; i++) {

            byteCodes.add((byte) i);

            if (i == Constants.ILOOKUPSWITCH ||
                i == Constants.SLOOKUPSWITCH ||
                i == Constants.ITABLESWITCH  ||
                i == Constants.STABLESWITCH ) {

                switch (i) {

                    case Constants.STABLESWITCH:

                        byteCodes.add((byte) 0x0D);
                        byteCodes.add((byte) 0x0E);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x02);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x05);

                        byteCodes.add((byte) 0x01);
                        byteCodes.add((byte) 0x02);

                        byteCodes.add((byte) 0x03);
                        byteCodes.add((byte) 0x04);

                        byteCodes.add((byte) 0x05);
                        byteCodes.add((byte) 0x06);

                        byteCodes.add((byte) 0x07);
                        byteCodes.add((byte) 0x08);

                        break;

                    case Constants.ITABLESWITCH:

                        byteCodes.add((byte) 0x0D);
                        byteCodes.add((byte) 0x0E);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x02);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x05);

                        byteCodes.add((byte) 0x01);
                        byteCodes.add((byte) 0x02);

                        byteCodes.add((byte) 0x03);
                        byteCodes.add((byte) 0x04);

                        byteCodes.add((byte) 0x05);
                        byteCodes.add((byte) 0x06);

                        byteCodes.add((byte) 0x07);
                        byteCodes.add((byte) 0x08);

                        break;

                    case Constants.SLOOKUPSWITCH:

                        byteCodes.add((byte) 0xD0);
                        byteCodes.add((byte) 0x0D);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x03);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x12);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x13);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x20);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x21);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x42);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x43);

                        break;

                    case Constants.ILOOKUPSWITCH:

                        byteCodes.add((byte) 0xD0);
                        byteCodes.add((byte) 0x0D);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x03);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x12);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x13);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x20);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x21);

                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x42);
                        byteCodes.add((byte) 0x00);
                        byteCodes.add((byte) 0x43);

                        break;

                    default :

                        throw new Exception("Roger, we got a problem here...");
                }

            } else {

                if (Constants.INSTRUCTION_LENGTH[i & 0x00FF] > 1) {

                    for (int j = 1; j < Constants.INSTRUCTION_LENGTH[i & 0x00FF]; j++) {

                        byteCodes.add((byte) 0x42);
                    }
                }
            }
        }


        int expectedByteCodesSize = 0;

        for (int i = 0; i < 0xB9; i++) {

            if (Constants.INSTRUCTION_LENGTH[i] > 0) {

                expectedByteCodesSize += Constants.INSTRUCTION_LENGTH[i];
            }
        }

        /* add switches sizes */
        expectedByteCodesSize += 0x4A;

        Assert.assertEquals(expectedByteCodesSize, byteCodes.size());

        methodInfo.setBytecodes(byteCodes);

        capMethod.setMethodInfo(methodInfo);

        capMethod.buildInstructionList();

        Assert.assertEquals(0xB9, capMethod.getInstructionsList().size());
    }
}