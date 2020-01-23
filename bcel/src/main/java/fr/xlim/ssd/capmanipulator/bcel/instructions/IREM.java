package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class IREM extends ArithmeticInstruction implements ExceptionThrower {

    public IREM(int offSet) {
        super(offSet, Constants.IREM);
    }
}