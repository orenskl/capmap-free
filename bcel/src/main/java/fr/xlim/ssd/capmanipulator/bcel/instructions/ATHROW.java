package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ATHROW extends CapInstruction implements UnconditionalBranch, ExceptionThrower {

    public ATHROW(int offSet) {
        super(offSet, Constants.ATHROW);
    }
}