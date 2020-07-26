package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/26 20:15
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] splits = str.split(" ");
        if (pattern.length() != splits.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(2);
        for (int i = 0; i < pattern.length(); i++) {
            //1. 没有映射时执行
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(splits[i])) {
                    //2. 没有映射的情况下s[i]已被使用，则不匹配返回false
                    return false;
                }
                //3. 构建映射
                map.put(pattern.charAt(i), splits[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(splits[i])) {
                    //当前字符串与映射不匹配,返回false
                    return false;
                }
            }
        }
        return true;
    }
}
