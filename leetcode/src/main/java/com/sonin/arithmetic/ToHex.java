package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/8/1 9:52
 */
public class ToHex {

    public String toHex(int num) {
        Map<Integer, String> map = new HashMap<>(4);
        for (int i = 0; i < 10; i++) {
            map.put(i, "" + i);
        }
        map.put(10, "a");
        map.put(11, "b");
        map.put(12, "c");
        map.put(13, "d");
        map.put(14, "e");
        map.put(15, "f");
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            Integer temp = num % 16;
            stringBuilder.append(map.get(temp));
            num /= 16;
        }
        return stringBuilder.reverse().toString();
    }
}
