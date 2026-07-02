package com.demo.collectionsdemo.linkedlist;

import com.demo.collectionsdemo.model.Policy;

import java.util.LinkedList;

public class LinkedListCRUDExample {
    public static void main(String[] args) {
        LinkedList<Policy> policies = new LinkedList<>();

        policies.add(new Policy("P001", "NB"));
        policies.add(new Policy("P002", "UW"));
        System.out.println("----start----");
        policies.forEach(System.out::println);
        System.out.println("----Get----");
        System.out.println(policies.get(0));
        policies.set(0, new Policy("P001", "Issued"));
        System.out.println("----After set----");
        policies.forEach(System.out::println);
        policies.remove(1);
        System.out.println("----After remove----");
        policies.forEach(System.out::println);


    }
}
