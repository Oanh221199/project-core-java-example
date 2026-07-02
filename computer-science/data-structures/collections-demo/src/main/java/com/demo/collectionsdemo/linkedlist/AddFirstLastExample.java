package com.demo.collectionsdemo.linkedlist;

import java.util.LinkedList;

public class AddFirstLastExample {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        queue.addFirst("A");
        System.out.println("----After add first----");
        queue.forEach(System.out::println);

        queue.addFirst("B");
        System.out.println("----After add first----");
        queue.forEach(System.out::println);

        queue.addLast("C");
        System.out.println("----After add last----");
        queue.forEach(System.out::println);

        queue.addLast("D");
        System.out.println("----After add last----");
        queue.forEach(System.out::println);

        System.out.println(queue);
    }
}
