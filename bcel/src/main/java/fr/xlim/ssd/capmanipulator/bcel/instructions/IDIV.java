package fr.xlim.ssd.capmanipulator.bcel.instructions;

public class IDIV extends ArithmeticInstruction implements ExceptionThrower {

    public IDIV(int offSet) {
        super(offSet, Constants.IDIV);
    }
}