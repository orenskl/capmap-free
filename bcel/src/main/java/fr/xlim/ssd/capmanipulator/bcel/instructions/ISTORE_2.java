package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ISTORE_2 extends StoreInstruction implements IndexedInstruction {

    public ISTORE_2(int offSet) {
        super(offSet, Constants.ISTORE_2);
        index = 2;
    }
}