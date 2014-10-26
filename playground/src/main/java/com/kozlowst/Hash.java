package com.kozlowst;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tomek on 10/22/14.
 */
public class Hash {
    public static void main(String[] args) {
        String s1 = "Aa";
        String s2 = "BB";
        System.out.println("s1: " + s1.hashCode() + ", s2: " + s2.hashCode());
        Map<String, Integer> map = new HashMap<>();
        map.put(s1, 234);
        map.put(s2, 432);
        System.out.println(map.get(s1));
        System.out.println(map.get(s2));
    }
}
