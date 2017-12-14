package com.lukasz;

import java.util.*;

public class Memory {
    private List<MemoryBank> memoryBanks;
    private Set<MemoryDump> dumps;

    public Memory(String input) {
        this.memoryBanks = new ArrayList<>();
        dumps = new HashSet();

        Scanner scanner = new Scanner(input);
        while(scanner.hasNextInt()) {
            memoryBanks.add(new MemoryBank(scanner.nextInt()));
        }

    }

    public int reallocateBlocks() {
        int numberOfSteps = 0;

        while ( !looped() ) {
            int indexOfMemoryBankWithMostBlocks = findIndexOfMemoryBankWithMostBlocks();
            int numberOfBlockToReallocate = memoryBanks.get(indexOfMemoryBankWithMostBlocks).takeBlocks();

            int i = indexOfMemoryBankWithMostBlocks;
            while(numberOfBlockToReallocate > 0) {
                if(i < memoryBanks.size() - 1) {
                    i++;
                }else {
                    i = 0;
                }
                memoryBanks.get(i).addBlock();
                numberOfBlockToReallocate--;
            }

            numberOfSteps++;
        }

        return numberOfSteps;
    }

    public int findSizeOfLoop() {
        dumps.clear();
        return reallocateBlocks();
    }

    private int findIndexOfMemoryBankWithMostBlocks() {
        int index = 0;
        int max = 0;
        for(int i = 0; i < memoryBanks.size(); i++) {
            int currentMemoryBankBlocks = memoryBanks.get(i).getNumberOfBlocks();
            if(currentMemoryBankBlocks > max ) {
                max = currentMemoryBankBlocks;
                index = i;
            }
        }

        return index;
    }

    private boolean looped() {
        return !dumpMemory();
    }

    private boolean dumpMemory() {
        MemoryDump memoryDump = new MemoryDump(memoryBanks);
        return dumps.add(memoryDump);
    }

}
