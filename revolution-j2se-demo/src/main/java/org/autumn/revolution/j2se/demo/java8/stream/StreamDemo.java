package org.autumn.revolution.j2se.demo.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * created by yangzhichao on 2019/3/4
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream().filter(s -> s.startsWith("c"))
                .map(String::toUpperCase).sorted()
                .forEach(System.out::println);

    }
}
