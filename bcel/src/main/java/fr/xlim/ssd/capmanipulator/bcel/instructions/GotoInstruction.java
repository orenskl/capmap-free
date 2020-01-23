package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class GotoInstruction extends BranchInstruction implements UnconditionalBranch {

    int jumpOffSet;
    
    public GotoInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }

    public int getJumpOffSet() {
        return jumpOffSet;
    }

    public void setJumpOffSet(int jumpOffSet) {
        this.jumpOffSet = jumpOffSet;
    }
}
