package com.company.benchmark;

public class Timer {

    public static long measure(Runnable task) {

        long start = System.nanoTime();

        task.run();

        long end = System.nanoTime();

        return end - start;
    }

    public static void printResult(String algorithm, int inputSize, long nanoTime) {

        System.out.println("----------------------------------------");
        System.out.println("Algorithm : " + algorithm);
        System.out.println("Input Size: " + inputSize);
        System.out.printf("Time      : %.3f ms%n", nanoTime / 1_000_000.0);
        System.out.println("----------------------------------------");
    }
}
