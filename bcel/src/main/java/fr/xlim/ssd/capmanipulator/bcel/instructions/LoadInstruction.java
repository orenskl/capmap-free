package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class LoadInstruction extends LocalVariableInstruction implements PushInstruction {

    
    public LoadInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }

}
