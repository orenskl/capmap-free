package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class CPInstruction extends CapInstruction implements TypedInstruction, IndexedInstruction {

    int index;
    
    public CPInstruction(int offSet, short opCode) {
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
