package com.demo.collectionsdemo.array;

import java.util.ArrayList;
import java.util.List;

public class ResizeExample {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        int capacity = 10;

        for (int i = 1; i <= 40; i++) {

            if (list.size() == capacity) {

                int oldCapacity = capacity;
                capacity = oldCapacity + (oldCapacity >> 1);

                System.out.printf(
                        "Resize: %d -> %d%n",
                        oldCapacity,
                        capacity
                );
            }

            list.add(i);

            System.out.printf(
                    "Add %-2d Size=%-2d Capacity=%d%n",
                    i,
                    list.size(),
                    capacity
            );
        }
    }
}