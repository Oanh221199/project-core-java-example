package com.demo.collectionsdemo.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class InsertMiddleExample {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> linked = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            array.add("A");
            linked.add("A");
        }

        long start = System.nanoTime();
        array.add(50000, "NEW");
        System.out.println("ArrayList: " + (System.nanoTime() - start));

        start = System.nanoTime();
        linked.add(50000, "NEW");
        System.out.println("LinkedList: " + (System.nanoTime() - start));
    }
}
