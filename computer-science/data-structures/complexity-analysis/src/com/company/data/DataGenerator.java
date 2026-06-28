package com.company.data;

import java.util.Random;

public class DataGenerator {

    private static final Random RANDOM = new Random();

    public static int[] generate(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextInt(1_000_000); // Giá trị từ 0 đến 999999
        }

        return arr;
    }
}
