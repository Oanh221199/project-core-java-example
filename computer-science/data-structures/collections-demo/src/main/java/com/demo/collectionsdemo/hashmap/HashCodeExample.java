package com.demo.collectionsdemo.hashmap;

public class HashCodeExample {
    public static void main(String[] args) {
        String key = "P001";

        System.out.println(key.hashCode());

        int bucket = Math.abs(key.hashCode()) % 16;

        System.out.println(bucket);
    }
}
