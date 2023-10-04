package datastructures.hashmap;

import java.util.LinkedList;

public class HMap {
//    large prime number to be our map size.
    private final int SIZE = 2069;
    private LinkedList<MapNode>[] hmap;

//    Initialize in constructor.
    public HMap() {
        hmap = new LinkedList[SIZE];
    }

//  Get: Returns the value to which the specified key is mapped or -1 if this map contains no mapping for the key.
    public int get(int key) {
        int bucketID = key % SIZE;
        if(hmap[bucketID] == null) return -1;
//      Since we return here it is OK to modify the linked list in the foreach loop.
        for(MapNode node: hmap[bucketID]) {
            if(node.getKey() == key) return node.getValue();
        }
        return -1;
    }
//  Put: Value will always be non-negative.
    public void put(int key, int value) {
        int bucketID = key % SIZE;
        if(hmap[bucketID] == null)
            hmap[bucketID] = new LinkedList<>();
//  Since we return here it is OK to modify the linked list in the foreach loop.
        for(MapNode node : hmap[bucketID]) {
            if(node.getKey() == key) {
                node.setValue(value);
                return;
            }
        }
        MapNode node = new MapNode(key, value);
        hmap[bucketID].add(node);
    }

//    Remove: Removes the mapping of the specified value key if this map contains a mapping for the key.
    public void remove(int key) {
        int bucketID = key % SIZE;
        if(hmap[bucketID] == null) return;
        for(MapNode node : hmap[bucketID]) {
            if(node.getKey() == key) {
                hmap[bucketID].remove(node);
                return;
            }
        }
    }
}

/*

HashMap:

The most distinguishable characteristic about hashmap is that it provides fast access to a value that is associated with a given key.
There are two main issues that we should tackle in order to design an efficient hashmap data structure: 1) hash function design and 2) collision handling.
As one of the most intuitive implementations, we could adopt the modulo operator as the hash function, since the key value is of integer type.
In addition, in order to minimize the potential collisions, it is advisable to use a prime number as the base of modulo, e.g. 2069.
We organize the storage space as an array where each element is indexed with the output value of the hash function.
In case of collision, where two different keys are mapped to the same address, we use a bucket to hold all the values.
The bucket is a container that holds all the values that are assigned by the hash function.
We could use either a LinkedList or an Array to implement the bucket data structure.

Complexity Analysis:

Time Complexity: for each of the methods, the time complexity is O(N/K)
where N is the number of all possible keys and K is the number of predefined buckets in the hashmap, which is 2069 in our case.

In the ideal case, the keys are evenly distributed in all buckets. As a result, on an average, we could consider the size of the bucket is N/K.
Since in the worst case we need to iterate through an entire bucket to find the desired value, the time complexity of each method is O(N/K).

Space Complexity: O(K+M) where K is the number of predefined buckets in the hashmap and M is the number of unique keys that have been inserted into the hashmap.
 */