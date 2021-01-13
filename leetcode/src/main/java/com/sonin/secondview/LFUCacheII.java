package com.sonin.secondview;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author sonin
 * @date 2021/1/13 9:23
 */
public class LFUCacheII {

    private Map<Integer, Integer> key2Val;

    private Map<Integer, Integer> key2Freq;

    private Map<Integer, LinkedHashSet<Integer>> freq2Keys;

    private int minFreq;

    private int capacity;

    public LFUCacheII(int capacity) {
        key2Val = new HashMap<>(2);
        key2Freq = new HashMap<>(2);
        freq2Keys = new HashMap<>(2);
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!key2Val.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return key2Val.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity <= 0) {
            return;
        }
        if (key2Val.containsKey(key)) {
            key2Val.put(key, value);
            increaseFreq(key);
            return;
        }
        if (this.capacity <= key2Val.size()) {
            removeMinFreqKey();
        }
        key2Val.put(key, value);
        key2Freq.put(key, 1);
        freq2Keys.putIfAbsent(1, new LinkedHashSet<>());
        freq2Keys.get(1).add(key);
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = freq2Keys.get(this.minFreq);
        int toDeleteKey = keys.iterator().next();
        keys.remove(toDeleteKey);
        if (keys.isEmpty()) {
            freq2Keys.remove(this.minFreq);
        }
        key2Val.remove(toDeleteKey);
        key2Freq.remove(toDeleteKey);
    }

    private void increaseFreq(int key) {
        int freq = key2Freq.get(key);
        key2Freq.put(key, freq + 1);
        freq2Keys.get(freq).remove(key);
        freq2Keys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freq2Keys.get(freq + 1).add(key);
        if (freq2Keys.get(freq).isEmpty()) {
            freq2Keys.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }
}
