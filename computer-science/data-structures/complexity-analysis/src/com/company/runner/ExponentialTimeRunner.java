package com.company.runner;

import com.company.benchmark.Timer;
import com.company.complexity.ExponentialTime;

public class ExponentialTimeRunner {

    public static void run() {

        int[] inputs = {
                10,
                20,
                30,
                35,
                40
        };

        for (int n : inputs) {

            long time = Timer.measure(() -> {
                ExponentialTime.fibonacci(n);
            });

            Timer.printResult("O(2^n)", n, time);

        }

    }

}