package com.company.runner;

import com.company.benchmark.BenchmarkRunner;
import com.company.complexity.QuadraticTime;
import com.company.data.DataGenerator;

public class QuadraticTimeRunner {

    public static void run() {

        int size = 1000;
        // 10k -> 100 triệu phép so sánh (đã khá nặng rồi)

        int[] arr = DataGenerator.generate(size);

        BenchmarkRunner.run(
                "O(n^2) - Quadratic Time",
                size,
                () -> QuadraticTime.countPairs(arr)
        );
    }
}