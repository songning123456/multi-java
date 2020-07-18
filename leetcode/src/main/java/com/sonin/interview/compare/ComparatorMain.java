package com.sonin.interview.compare;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author sonin
 * @date 2020/7/18 22:47
 */
public class ComparatorMain {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("ccc", 20));
        list.add(new Person("AAA", 30));
        list.add(new Person("bbb", 10));
        list.add(new Person("ddd", 40));
        System.out.println("Comparator-before: " + list);
        AscComparator ascComparator = new AscComparator();
        list.sort(ascComparator);
        System.out.println("Comparator-asc: " + list);
        DescComparator descComparator = new DescComparator();
        list.sort(descComparator);
        System.out.println("Comparator-desc: " + list);
    }
}
