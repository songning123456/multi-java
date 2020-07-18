package com.sonin.interview.compare;

import java.util.Comparator;

/**
 * @author sonin
 * @date 2020/7/18 22:51
 */
public class DescComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person2.getAge() - person1.getAge();
    }
}
