package com.sonin.interview.compare;

import java.util.Comparator;

/**
 * @author sonin
 * @date 2020/7/18 22:51
 */
public class AscComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}
