package com.sonin.arithmetic;

import java.util.*;

/**
 * @author sonin
 * @date 2020/7/26 21:10
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        int A = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            }
        }
        Map<Character, Integer> mapS = new HashMap<>(2);
        Map<Character, Integer> mapG = new HashMap<>(2);
        for (int i = 0; i < secret.length(); i++) {
            mapS.put(secret.charAt(i), mapS.getOrDefault(secret.charAt(i), 0) + 1);
            mapG.put(guess.charAt(i), mapG.getOrDefault(secret.charAt(i), 0) + 1);
        }
        int B = 0;
        for (Character character : mapS.keySet()) {
            int m = mapS.getOrDefault(character, 0);
            int n = mapG.getOrDefault(character, 0);
            B += Math.min(m, n);
        }
        return A + "A" + (B - A) + "B";
    }
}
