package com.demo.collectionsdemo.array;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return elements.length;
    }

    public void add(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    public T remove(int index) {
        checkIndex(index);
        T old = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return old;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(elements)) {
                return true;
            }
            ;
        }
        return false;
    }

    private void resize() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.printf("Resize: %d -> %d%n",
                oldCapacity,
                newCapacity);
        elements = Arrays.copyOf(
                elements,
                newCapacity
        );
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public void print() {

        System.out.println("Size = " + size +
                ", Capacity = " + capacity());

        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }

        System.out.println("---------------------");
    }



}
