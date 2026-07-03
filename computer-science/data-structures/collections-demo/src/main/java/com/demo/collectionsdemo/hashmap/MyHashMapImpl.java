package com.demo.collectionsdemo.hashmap;

public class MyHashMapImpl<K, V> implements MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;

    private Node<K, V>[] buckets;

    private int size;

    public MyHashMapImpl() {
        buckets = new Node[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {

        int index = index(key);

        Node<K, V> current = buckets[index];

        // Bucket rỗng
        if (current == null) {
            buckets[index] = new Node<>(key, value);
            size++;
            return;
        }

        // Duyệt LinkedList
        while (true) {

            // Key đã tồn tại -> update value
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }

            // Đã tới node cuối
            if (current.next == null) {
                break;
            }

            // Sang node tiếp theo
            current = current.next;
        }

        // Thêm node mới vào cuối LinkedList
        current.next = new Node<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        int index = index(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = index(key);
        Node<K, V> current = buckets[index];
        Node<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int index = index(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private int index(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

}
