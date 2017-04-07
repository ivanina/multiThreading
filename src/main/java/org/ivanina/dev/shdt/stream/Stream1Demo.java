package org.ivanina.dev.shdt.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Stream1Demo {
    public static void main(String[] args) {
        ArrayList<Integer> iList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            iList.add(ThreadLocalRandom.current().nextInt(1, 100));
        }

        System.out.println("First elements: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d, ", iList.get(i));
        }

        Stream<Integer> iStream = iList.stream();
        Optional<Integer> iOpt = iStream.min(Integer::compare);
        System.out.println("\nMin: " + iOpt.get());

        iStream = iList.stream();
        iOpt = iStream.max(Integer::compare);
        System.out.println("Max: " + iOpt.get());

        System.out.println("Sorted list: ");
        iList.stream().sorted().forEach((n) -> System.out.printf("%2d, ", n));

        System.out.println("\nOdd values (sorted):");
        iList.stream().filter((n) -> n % 2 == 0).sorted(Integer::compareTo).forEach((n) -> System.out.printf("%2d, ", n));

        System.out.println("\nReduce wih Optional: " + iList.stream().filter((n) -> n > 1).reduce((a, b) -> a * b));

        ArrayList<Integer> iList2 = new ArrayList<>();
        iList2.add(1);
        iList2.add(5);
        iList2.add(6);
        iList2.add(7);
        iList2.add(9);
        System.out.println("Reduce wih Optional: " + iList2.stream().reduce((a, b) -> a * b));


    }
}
