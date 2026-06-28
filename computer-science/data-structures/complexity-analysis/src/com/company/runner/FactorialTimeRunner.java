package com.company.runner;

import com.company.benchmark.BenchmarkRunner;
import com.company.complexity.FactorialTime;
import com.company.data.DataGenerator;

public class FactorialTimeRunner {
    public static void run() {
        // Không nên lớn hơn 10 vì O(n!) tăng rất nhanh.
        int size = 3;
        int[] arr = DataGenerator.generate(size);

        // Benchmark thuật toán O(n!)
        BenchmarkRunner.run(
                "O(n!) - Factorial Time",
                size,
                () -> FactorialTime.execute(arr)
        );
    }
}
