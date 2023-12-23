package datastructures.pair;


import java.io.Serializable;

public class Pair<K,V> implements Serializable {
//    private static final long serialVersionUID = 1L;
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

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Pair)) return false;
        Pair<K,V> other = (Pair) o;
        boolean pairKeyEquals = ((this.key == null && other.getKey() == null) || this.key != null && this.key == other.getKey());
        return this.value == other.getValue() && pairKeyEquals;
    }

    @Override
    public final int hashCode() {
        int result = 20;
        if(key != null) {
            result += key.hashCode();
        }
        if(value != null) {
            result += value.hashCode();
        }
        return result;
    }
}
