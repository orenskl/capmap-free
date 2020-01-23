package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ISTORE_1 extends StoreInstruction implements IndexedInstruction {

    public ISTORE_1(int offSet) {
        super(offSet, Constants.ISTORE_1);
        index = 1;
    }
}