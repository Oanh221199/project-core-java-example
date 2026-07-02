package com.demo.collectionsdemo.array;

import com.demo.collectionsdemo.model.Policy;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();
         // Add
        policies.add(new Policy("80030038","Contract"));
        policies.add(new Policy("80030039","NB"));
        policies.add(new Policy("80030040","UW"));
        System.out.println("---List policies after add---");
        policies.forEach(System.out::println);

        // Get
        Policy policy = policies.get(0);
        System.out.println("---Get policy---");
        System.out.println(policy.toString());

        //Update
        policies.set(1, new Policy("80030041","KeyIn"));
        System.out.println("---List policies after update---");
        policies.forEach(System.out::println);

        //Remove
        policies.remove(2);
        System.out.println("---List policies after remove---");
        policies.forEach(System.out::println);

        //Contains
        boolean c = policies.contains(new Policy("80030041", "KeyIn"));
        System.out.println("---List policies contains---");
        System.out.println(c);

        //Empty
        System.out.println("---List policies empty---");
        System.out.println(policies.isEmpty());
    }
}
