package com.company.runner;

import com.company.benchmark.BenchmarkRunner;
import com.company.complexity.LogarithmicTime;
import com.company.data.DataGenerator;

import java.util.Arrays;

public class LogarithmicTimeRunner {

    public static void run() {

        int size = 1_000_000;

        int[] arr = DataGenerator.generate(size);
        Arrays.sort(arr); // Binary search yêu cầu mảng đã sắp xếp

        int target = arr[size / 2];

        BenchmarkRunner.run(
                "O(log n) - Logarithmic Time",
                size,
                () -> LogarithmicTime.execute(arr, target)
        );
    }
}