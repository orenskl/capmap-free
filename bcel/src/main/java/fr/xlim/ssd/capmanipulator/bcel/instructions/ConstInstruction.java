package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class ConstInstruction extends CapInstruction implements ConstantPushInstruction, StackProducer {

    int value;

    public ConstInstruction(int offSet, short opCode) {
        super(offSet, opCode);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}
