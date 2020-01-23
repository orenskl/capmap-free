package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class JsrInstruction extends BranchInstruction implements UnconditionalBranch, TypedInstruction, StackProducer {

    int jumpOffSet;
    
    public JsrInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }

    public int getJumpOffSet() {
        return jumpOffSet;
    }

    public void setJumpOffSet(int jumpOffSet) {
        this.jumpOffSet = jumpOffSet;
    }
}
