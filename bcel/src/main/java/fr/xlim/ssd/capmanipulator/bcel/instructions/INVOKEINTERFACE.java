package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.ArrayList;

public class INVOKEINTERFACE extends InvokeInstruction implements IndexedInstruction {

    private byte nArgs;
    private byte method;

    public INVOKEINTERFACE(int offSet, ArrayList<Byte> byteArray) {
        super(offSet, Constants.INVOKEINTERFACE);
        nArgs = byteArray.get(offSet + 1);
        index = (byteArray.get(offSet + 2) << 8) | byteArray.get(offSet + 3);
        method = byteArray.get(offSet + 4);
    }

    public byte getnArgs() {
        return nArgs;
    }

    public void setnArgs(byte nArgs) {
        this.nArgs = nArgs;
    }

    public byte getMethod() {
        return method;
    }

    public void setMethod(byte method) {
        this.method = method;
    }
}