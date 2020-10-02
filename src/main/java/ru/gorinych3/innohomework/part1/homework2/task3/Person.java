package ru.gorinych3.innohomework.part1.homework2.task3;

public class Person implements Comparable{

    private int age;

    private String name;

    private Sex sex;

    public Person() {
    }

    public Person(int age, String name, Sex sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return this.getName().compareTo(person.getName());
    }
}
