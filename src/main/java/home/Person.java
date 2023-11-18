package home;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;

    protected int age;

    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = 0;
        this.address = StringUtils.EMPTY;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = StringUtils.EMPTY;
    }

    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasAddress() {
        return StringUtils.isNotBlank(address);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.getSurname());
        childBuilder.setAddress(this.getAddress());
        childBuilder.setAge(0);
        return childBuilder;
    }
}
