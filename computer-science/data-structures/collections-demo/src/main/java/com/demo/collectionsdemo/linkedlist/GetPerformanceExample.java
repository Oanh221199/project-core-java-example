package com.demo.collectionsdemo.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class GetPerformanceExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 1_000_000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.nanoTime();
        arrayList.get(999_999);
        System.out.println("ArrayList: " + (System.nanoTime() - start));

        start = System.nanoTime();
        linkedList.get(999_999);
        System.out.println("LinkedList: " + (System.nanoTime() - start));
    }
}
