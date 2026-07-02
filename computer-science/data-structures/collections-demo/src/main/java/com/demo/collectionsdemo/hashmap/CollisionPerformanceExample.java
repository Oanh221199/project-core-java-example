package com.demo.collectionsdemo.hashmap;

import java.util.HashMap;
import java.util.Map;

public class CollisionPerformanceExample {

    static class BadKey {
        private final int id;

        public BadKey(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return 1;   // Tất cả key đều vào cùng một bucket
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof BadKey)) return false;
            return this.id == ((BadKey) obj).id;
        }
    }

    public static void main(String[] args) {

        final int SIZE = 10_000;

        // HashMap bình thường
        Map<Integer, Integer> normalMap = new HashMap<>();

        // HashMap bị collision
        Map<BadKey, Integer> collisionMap = new HashMap<>();

        for (int i = 0; i < SIZE; i++) {
            normalMap.put(i, i);
            collisionMap.put(new BadKey(i), i);
        }

        // Warm-up cho JVM
        for (int i = 0; i < 10_000; i++) {
            normalMap.get(SIZE - 1);
            collisionMap.get(new BadKey(SIZE - 1));
        }

        // Đo thời gian get() bình thường
        long start = System.nanoTime();

        for (int i = 0; i < 1_000_000; i++) {
            normalMap.get(SIZE - 1);
        }

        long normalTime = System.nanoTime() - start;

        // Đo thời gian get() khi collision
        start = System.nanoTime();

        for (int i = 0; i < 1_000_000; i++) {
            collisionMap.get(new BadKey(SIZE - 1));
        }

        long collisionTime = System.nanoTime() - start;

        System.out.println("Normal HashMap : " + normalTime / 1_000_000.0 + " ms");
        System.out.println("Collision HashMap : " + collisionTime / 1_000_000.0 + " ms");
    }
}