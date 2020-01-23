package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class JSR extends JsrInstruction implements VariableLengthInstruction {

    public JSR(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.JSR);
        jumpOffSet = (byteArray.get(offSet + 1) << 8) | byteArray.get(offSet + 2);
    }
}