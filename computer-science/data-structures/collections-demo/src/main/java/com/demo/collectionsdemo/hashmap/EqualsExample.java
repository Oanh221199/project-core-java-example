package com.demo.collectionsdemo.hashmap;

import com.demo.collectionsdemo.model.Policy;

public class EqualsExample {
    public static void main(String[] args) {
        Policy policy = new Policy("P001","NB");
        Policy policy2 = new Policy("P001","NB");
        System.out.println(policy.equals(policy2));
        System.out.println(policy==policy2);
    }
}
