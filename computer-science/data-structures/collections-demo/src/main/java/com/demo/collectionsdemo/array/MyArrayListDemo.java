package com.demo.collectionsdemo.array;

public class MyArrayListDemo {

    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 1; i <= 20; i++) {

            list.add("Policy-" + i);

            System.out.printf(
                    "Add %-2d | Size=%d | Capacity=%d%n",
                    i,
                    list.size(),
                    list.capacity()
            );
        }

        System.out.println();

        System.out.println("Element at index 5");
        System.out.println(list.get(5));

        System.out.println();

        list.set(5, "Updated Policy");

        System.out.println(list.get(5));

        System.out.println();

        list.remove(3);

        list.print();
    }

}