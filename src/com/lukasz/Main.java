package com.lukasz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter blocks data: ");
        String input = scanner.nextLine();
        Memory memory = new Memory(input);

        System.out.println("Loop was detected in " + memory.reallocateBlocks() + " steps.");
        System.out.println("Loop size is " + memory.findSizeOfLoop() + " steps.");
    }
}
