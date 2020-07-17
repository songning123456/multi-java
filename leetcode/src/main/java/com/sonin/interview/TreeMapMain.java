package com.sonin.interview;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author sonin
 * @date 2020/7/16 23:21
 */
public class TreeMapMain {
    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.method();
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("3", 3);
        treeMap.put("2", 2);
        treeMap.put("1", 1);
        treeMap.put("4", 4);
        for (Map.Entry<String, Integer> item : treeMap.entrySet()) {
            String key = item.getKey();
            Integer value = item.getValue();
            System.out.println("key -> " + key + "; value -> " + value);
        }
    }
}
