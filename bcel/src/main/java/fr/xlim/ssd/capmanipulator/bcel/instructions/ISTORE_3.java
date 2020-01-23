package fr.xlim.ssd.capmanipulator.bcel.instructions;
public class ISTORE_3 extends StoreInstruction implements IndexedInstruction {

    public ISTORE_3(int offSet) {
        super(offSet, Constants.ISTORE_3);
        index = 3;
    }
}