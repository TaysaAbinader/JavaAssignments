package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Maria", 15, "Manaus"));
        people.add(new Person("Juha", 32, "Helsinki"));
        people.add(new Person("Sofia", 65, "Lisbon"));
        people.add(new Person("John", 28, "San Francisco"));

        // 1. Sort by age (ascending) using lambdas.
        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println("Sorted by age (lambdas): " + people);

        // 2. Sort by age (ascending) using Comparator.
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println("Sorted by age (Comparator): " + people);

        // 3. Filter by city using lambdas.
        System.out.print("People from Manaus: ");
        people.stream().filter(person -> person.getCity().equals("Manaus")).forEach(System.out::println);

        // 4. Filter by city using Comparator.
        List<Person> fromHelsinkiSorted = people.stream()
                .filter(person -> person.getCity().equals("Helsinki"))
                .toList();
        System.out.println("People from Helsinki: " + fromHelsinkiSorted);
    }
}
