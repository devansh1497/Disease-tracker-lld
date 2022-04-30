package model;

import java.util.List;

public class TotalAndNamesPair {
    int number;
    List<Person> people;

    public TotalAndNamesPair(int number, List<Person> people) {
        this.number = number;
        this.people = people;
    }


    @Override
    public String toString() {
        return "TotalAndNamesPair{" +
                "number=" + number +
                ", people=" + people +
                '}';
    }
}
