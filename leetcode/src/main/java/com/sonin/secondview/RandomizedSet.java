package com.sonin.secondview;

import java.util.*;

/**
 * @author sonin
 * @date 2020/12/29 10:23
 */
public class RandomizedSet {

    private Map<Integer, Integer> valToIndexMap;

    private List<Integer> numList;

    private Random rand;

    public RandomizedSet() {
        valToIndexMap = new HashMap<>();
        numList = new LinkedList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndexMap.containsKey(val)) {
            return false;
        }
        numList.add(val);
        valToIndexMap.put(val, numList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndexMap.containsKey(val)) {
            return false;
        }
        int index = valToIndexMap.get(val);
        numList.remove(index);
        valToIndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return numList.get(rand.nextInt(numList.size()));
    }
}
