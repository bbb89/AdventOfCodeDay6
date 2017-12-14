package com.lukasz;

public class MemoryBank {
    private int numberOfBlocks;
    private int initialNumberOfBanks;


    public MemoryBank(int numberOfBlocks) {
        this.numberOfBlocks = numberOfBlocks;
        this.initialNumberOfBanks = numberOfBlocks;
    }

    public int getNumberOfBlocks() {
        return numberOfBlocks;
    }

    public void addBlock() {
        numberOfBlocks++;
    }

    public int takeBlocks() {
        int blocksNumber = numberOfBlocks;
        numberOfBlocks = 0;
        return blocksNumber;
    }

    @Override
    public String toString() {
        return "numberOfBlocks=" + numberOfBlocks;
    }
}
