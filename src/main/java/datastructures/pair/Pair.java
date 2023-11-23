package datastructures.pair;


import java.io.Serializable;

public class Pair<K,V> implements Serializable {
    private static final long serialVersionUID = 1L;
    public K key;
    public V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}
