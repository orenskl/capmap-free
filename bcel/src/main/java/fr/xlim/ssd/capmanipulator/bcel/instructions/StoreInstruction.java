package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class StoreInstruction extends LocalVariableInstruction implements PopInstruction {

    public StoreInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }
}
