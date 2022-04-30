package model;

public class Person {
    String name;
    Location location;

    public Person(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
