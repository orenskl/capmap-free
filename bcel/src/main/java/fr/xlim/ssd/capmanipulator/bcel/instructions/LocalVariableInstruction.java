package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class LocalVariableInstruction extends CapInstruction implements TypedInstruction, IndexedInstruction {
    
    int index;

    public LocalVariableInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }
}
