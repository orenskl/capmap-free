package fr.xlim.ssd.capmanipulator.bcel.instructions;


public abstract class CapInstruction {
    
    protected int offSet;
    protected short opCode;

    CapInstruction(int offSet, short opCode) {
        this.offSet = offSet;
        this.opCode = opCode;
    }

    public String getName() {
        return Constants.INSTRUCTION_NAME[opCode];
    }

    public int getLength() {
        return Constants.INSTRUCTION_LENGTH[opCode];
    }

    public int consumeStack() {
        return Constants.CONSUME_STACK[opCode];
    }
    
    public int produceStack() {
        return Constants.PRODUCE_STACK[opCode];
    }

    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public short getOpCode() {
        return opCode;
    }

    public void setOpCode(short opCode) {
        this.opCode = opCode;
    }
}
