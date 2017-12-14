package com.lukasz;

import java.util.Arrays;
import java.util.List;

public class MemoryDump {
    private int[] values;

    public MemoryDump(List<MemoryBank> memoryBanks) {
        values = new int[memoryBanks.size()];

        for(int i = 0; i < memoryBanks.size(); i++) {
            values[i] = memoryBanks.get(i).getNumberOfBlocks();
        }
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public boolean equals(Object obj) {
        return Arrays.equals(values, ((MemoryDump) obj).getValues());
    }
}
