package fr.xlim.ssd.capmanipulator.bcel.instructions;

import java.util.HashMap;
import java.util.Map;

public class Select extends BranchInstruction implements VariableLengthInstruction, StackConsumer {

    protected int defaultJump;
    protected int nbPairs;
    protected Map<Integer, Integer> jumpTable = new HashMap<Integer, Integer>();
    protected int length;

    public Select(int offSet, short opCode) {
        super(offSet, opCode);
    }

    public void addPair(int key, int offSet) {
        jumpTable.put(key, offSet);
    }

    public Map<Integer, Integer> getJumpTable() {
        return jumpTable;
    }

    public void setJumpTable(Map<Integer, Integer> jumpTable) {
        this.jumpTable = jumpTable;
    }

    public int getNbPairs() {
        return nbPairs;
    }

    public void setNbPairs(int nbPairs) {
        this.nbPairs = nbPairs;
    }

    public int getDefaultJump() {
        return defaultJump;
    }

    public void setDefaultJump(int defaultJump) {
        this.defaultJump = defaultJump;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
