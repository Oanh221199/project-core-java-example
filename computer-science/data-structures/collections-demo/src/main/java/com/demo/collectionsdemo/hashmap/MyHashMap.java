package com.demo.collectionsdemo.hashmap;

public interface MyHashMap<K, V> {

    public void put(K key, V value);

    public V get(K key);

    public V remove(K key);

    public boolean containsKey(K key);

    public int size();

    public boolean isEmpty();

    public void clear();


}
