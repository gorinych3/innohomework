package ru.gorinych3.innohomework.homework.task5.part1;

public class Person implements Comparable<Person> {

    private String personName;

    private int age;

    private Sex sex;

    public Person() {
    }

    public Person(String name, int age, Sex sex) {
        this.personName = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return personName;
    }

    public void setName(String name) {
        this.personName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                "personName='" + personName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                personName.equals(person.personName) &&
                sex == person.sex;
    }

    @Override
    public int hashCode() {
        return personName.hashCode() + age + sex.hashCode();
    }

    @Override
    public int compareTo(Person o) {
        return this.personName.compareTo(o.personName);
    }
}
