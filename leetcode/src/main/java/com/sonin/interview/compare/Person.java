package com.sonin.interview.compare;

/**
 * @author sonin
 * @date 2020/7/18 22:23
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        return person.age - this.age;
    }

    @Override
    public String toString() {
        return this.name + "-" + this.age;
    }
}
