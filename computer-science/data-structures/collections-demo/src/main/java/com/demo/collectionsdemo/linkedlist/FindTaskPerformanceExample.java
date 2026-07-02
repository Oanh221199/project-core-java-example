package com.demo.collectionsdemo.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindTaskPerformanceExample {

    public static void main(String[] args) {

        int size = 500_000;

        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            String task = "Task-" + i;
            arrayList.add(task);
            linkedList.add(task);
        }

        // Warm up
        for (int i = 0; i < 10000; i++) {
            arrayList.get(size - 1);
            linkedList.get(size - 1);
        }

        // ArrayList
        long start = System.nanoTime();

        String task1 = arrayList.get(size - 1);

        long arrayTime = System.nanoTime() - start;

        // LinkedList
        start = System.nanoTime();

        String task2 = linkedList.get(size - 1);

        long linkedTime = System.nanoTime() - start;

        System.out.println(task1);
        System.out.println(task2);

        System.out.printf("ArrayList get(): %.3f µs%n", arrayTime / 1000.0);
        System.out.printf("LinkedList get(): %.3f µs%n", linkedTime / 1000.0);
    }
}