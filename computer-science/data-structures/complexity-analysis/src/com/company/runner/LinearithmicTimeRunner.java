package com.company.runner;

import com.company.benchmark.BenchmarkRunner;
import com.company.complexity.LinearithmicTime;
import com.company.data.DataGenerator;

public class LinearithmicTimeRunner {

    public static void run() {

        int size = 10;

        int[] arr = DataGenerator.generate(size);

        BenchmarkRunner.run(
                "O(n log n) - Linearithmic Time",
                size,
                () -> LinearithmicTime.execute(arr.clone())
        );
    }
}