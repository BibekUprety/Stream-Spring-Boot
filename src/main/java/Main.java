import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void  main(String[] args) {
        List<Person> people = getPeople();
//   Imperative approach
//        List<Person> females = new ArrayList<>();
//        for (Person person : people) {
//            if (person.getGender().equals(Gender.FEMALE)) {
//                females.add(person);
//            }
//        }
//        females.forEach(System.out::println);
//    Declarative Method
//        filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
//         females.forEach(System.out::println);

//        sort
        final List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());

//        sorted.forEach(System.out::println);

//        All Match
        boolean match = people.stream()
                .allMatch(person -> person.getAge() > 5);
//        System.out.println(match);

//        Any Match
         boolean anymatch = people.stream()
                .anyMatch(person -> person.getAge() > 150);
//        System.out.println(anymatch);

//        None Match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getAge() > 150);
//        System.out.println(noneMatch);

//        Max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
//        System.out.println(max);

////        Min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
//        Optional<Person> min = people.stream()
//                .min(Comparator.comparing(Person::getAge));
//        System.out.println(min);

//        Group
//        Map<Gender, List<Person>> groupBygender = people.stream()
//                .collect(Collectors.groupingBy(Person::getGender));
//        groupBygender.forEach((gender, people1) -> {
//            System.out.println(gender);
//            people1.forEach(System.out::println);
//            System.out.println();
//        });
        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemale.ifPresent(System.out::println);


    }
    private static List<Person> getPeople() {
        return List.of(
                new Person("abe", 20, Gender.MALE),
                new Person("xyz", 33, Gender.FEMALE),
                new Person("sfada", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
