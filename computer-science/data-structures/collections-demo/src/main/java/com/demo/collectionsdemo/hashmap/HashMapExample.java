package com.demo.collectionsdemo.hashmap;

import com.demo.collectionsdemo.model.Policy;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Policy> policies = new HashMap<>();

// Create
        policies.put("P001", new Policy("P001", "New Business"));
        policies.put("P002", new Policy("P002", "Underwriting"));

// Read
        System.out.println(policies.get("P001"));

// Update
        policies.put("P001", new Policy("P001", "Issued"));

// Delete
        policies.remove("P002");

// Contains
        System.out.println(policies.containsKey("P001"));

// Size
        System.out.println(policies.size());

// Traverse
        policies.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
