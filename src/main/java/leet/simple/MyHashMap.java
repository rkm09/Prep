package leet.simple;

import datastructures.hashmap.HMap;

public class MyHashMap {
    public static void main(String[] args) {
        HMap obj = new HMap();
        int key = 3, value = 1;
        obj.put(key, value);
        int param2 = obj.get(key);
        obj.remove(key);
        System.out.println(param2);
    }
}
