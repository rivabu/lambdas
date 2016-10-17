package com.rients.lamdba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Samples {

    static List<String> myList =
            Arrays.asList("a1", "a2", "b1", "c2", "c1");

    public static void main(String[] args) {

        myList
            .stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
        
        System.out.println("---");
        Arrays.stream(new int[] {1, 2, 3})
            .map(n -> 2 * n + 1)
            .average()
            .ifPresent(System.out::println);  // 5.0

        System.out.println("---");
        IntStream.range(1, 4)
            .mapToObj(i -> "a" + i )
            .forEach(System.out::println);

        System.out.println("---");
        Stream.of(1.0, 2.0, 3.0)
            .mapToInt(Double::intValue)
            .mapToObj(i -> "a" + i)
            .forEach(System.out::println);

        System.out.println("---");
        Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(s -> {
            System.out.println("filter: " + s);
            return true;
        })
        .forEach(s -> System.out.println("forEach: " + s));
    }

}
