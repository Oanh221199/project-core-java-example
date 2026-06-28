package com.company.runner;

import com.company.benchmark.BenchmarkRunner;
import com.company.complexity.ConstantExample;

public class ConstantRunner {

    public static void run() {

        int[] sizes = {
                10,
                100,
                1000,
                10000,
                100000,
                1000000
        };

        for (int size : sizes) {

            int[] arr = new int[size];

            BenchmarkRunner.run(
                    "O(1)",
                    size,
                    () -> ConstantExample.getElement(arr)
            );

        }

    }

}