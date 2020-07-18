package com.sonin.interview.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author sonin
 * @date 2020/7/18 22:29
 */
public class ComparableMain {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("ccc", 20));
        list.add(new Person("AAA", 30));
        list.add(new Person("bbb", 10));
        list.add(new Person("ddd", 40));
        System.out.println("Comparable-before: " + list);
        Collections.sort(list);
        System.out.println("Comparable-after: " + list);
    }
}
