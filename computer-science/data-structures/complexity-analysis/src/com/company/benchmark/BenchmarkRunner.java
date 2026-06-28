package com.company.benchmark;

public class BenchmarkRunner {

    private static final int WARMUP_COUNT = 100_000;
    private static final int BENCHMARK_COUNT = 10_000_000;

    public static void run(String algorithm,
                           int inputSize,
                           Runnable runnable) {

        warmUp(runnable);

        long time = Timer.measure(() -> {

            for (int i = 0; i < BENCHMARK_COUNT; i++) {
                runnable.run();
            }

        });

        Timer.printResult(algorithm, inputSize, time);
    }

    private static void warmUp(Runnable runnable) {

        for (int i = 0; i < WARMUP_COUNT; i++) {
            runnable.run();
        }

    }

}