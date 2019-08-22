package com.company.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LC380_RandomizeSet {
    private List<Integer> arr;
    private HashMap<Integer, Integer> map;
    private int size;
    /** Initialize your data structure here. */
    public LC380_RandomizeSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, size++);
        arr.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        int last = arr.get(size-1);
        arr.set(idx, last);
        map.put(last, idx);
        map.remove(val);
        arr.remove(size-1);
        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(size == 0) return -1;
        Random rand = new Random();
        return arr.get(rand.nextInt(size));
    }

}
