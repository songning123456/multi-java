package com.sonin.secondview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author sonin
 * @Date 2020/12/26 3:47 下午
 * @Version 1.0
 **/
public class LFUCache {

    private class Node {
        private int key;
        private int val;
        private int freq;

        public Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    private int minFreq;
    private int capacity;
    Map<Integer, Node> keyMap;
    Map<Integer, LinkedList<Node>> freqMap;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        int val = node.val;
        int freq = node.freq;
        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).size() == 0) {
            freqMap.remove(freq);
            if (minFreq == freq) {
                minFreq += 1;
            }
        }
        LinkedList<Node> linkedList = freqMap.getOrDefault(freq + 1, new LinkedList<>());
        linkedList.offerFirst(new Node(key, val, freq + 1));
        freqMap.put(freq + 1, linkedList);
        keyMap.put(key, freqMap.get(freq + 1).peekFirst());
        return val;
    }

    public void put(int key, int val) {
        if (capacity == 0) {
            return;
        }
        if (!keyMap.containsKey(key)) {
            if (keyMap.size() == capacity) {
                Node node = freqMap.get(minFreq).peekLast();
                keyMap.remove(node.key);
                freqMap.get(minFreq).pollLast();
                if (freqMap.get(minFreq).size() == 0) {
                    freqMap.remove(minFreq);
                }
            }
            LinkedList<Node> linkedList = freqMap.getOrDefault(1, new LinkedList<>());
            linkedList.offerFirst(new Node(key, val, 1));
            freqMap.put(1, linkedList);
            keyMap.put(key, freqMap.get(1).peekFirst());
            minFreq = 1;
        } else {
            Node node = keyMap.get(key);
            int freq = node.freq;
            freqMap.get(freq).remove(node);
            if (freqMap.get(freq).size() == 0) {
                freqMap.remove(freq);
                if (minFreq == freq) {
                    minFreq += 1;
                }
            }
            LinkedList<Node> linkedList = freqMap.getOrDefault(freq + 1, new LinkedList<>());
            linkedList.offerFirst(new Node(key, val, freq + 1));
            freqMap.put(freq + 1, linkedList);
            keyMap.put(key, freqMap.get(freq + 1).peekFirst());
        }
    }
}
