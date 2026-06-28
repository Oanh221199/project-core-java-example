package com.company.runner;

import com.company.benchmark.BenchmarkRunner;
import com.company.complexity.LinearTime;
import com.company.data.DataGenerator;

public class LinearRunner {

    public static void run() {

        int size = 1_000_000;

        int[] arr = DataGenerator.generate(size);

        BenchmarkRunner.run(
                "O(n) - Linear Time",
                size,
                () -> LinearTime.sum(arr)
        );
    }
}