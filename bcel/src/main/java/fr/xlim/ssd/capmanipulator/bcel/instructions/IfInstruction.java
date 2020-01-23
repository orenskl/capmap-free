package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class IfInstruction extends BranchInstruction implements StackConsumer {

    int jumpOffSet;
    
    public IfInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }

    public int getJumpOffSet() {
        return jumpOffSet;
    }

    public void setJumpOffSet(int jumpOffSet) {
        this.jumpOffSet = jumpOffSet;
    }
}
