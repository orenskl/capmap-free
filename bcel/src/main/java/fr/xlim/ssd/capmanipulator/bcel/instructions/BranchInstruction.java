package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class BranchInstruction extends CapInstruction implements InstructionTargeter {

    public BranchInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }
}
