package org.ivanina.dev.shdt.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2MapDemo {
    public static void main(String[] args) {
        ArrayList<Double> dList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dList.add(ThreadLocalRandom.current().nextDouble(1.0, 100.0));
        }
        System.out.println("Source: " + dList);

        Stream<Double> sqrtStream = dList.stream().map((n) -> Math.sqrt(n));
        System.out.println("Sqrt: ");
        sqrtStream.forEach(n -> System.out.printf("%.2f, ", n));

        System.out.println("\nsqrtStream ->> floor and reduce by sum: " +
                dList.stream()
                        .map((n) -> Math.sqrt(n))
                        .map((n) -> {
                            return Math.floor(n);
                        })
                        .reduce(0.0, (a, b) -> a + b)
        );

        System.out.println("double to int: ");
        dList.stream().mapToInt(n -> (int) Math.ceil(n)).forEach(n -> System.out.printf("%d, ",n));

        System.out.println("\ndouble thought Collect to Set: "+dList.stream().collect(Collectors.toSet()).getClass().getName() );

        LinkedList<Integer> iLL = dList.stream().collect(
                () -> new LinkedList<Integer>(),
                (list, item) -> list.add(  item.intValue() ),
                (listA, listB) -> listA.addAll(listB)
        );
        System.out.println("from ArrayList<Double> to LinkedList<Integer>. Class: " + iLL.getClass().getName());
        System.out.println("LinkedList<Integer>: "+iLL);

        HashSet<Double> dHS = dList.stream()
                .collect(
                        HashSet::new,
                        HashSet::add,
                        HashSet::addAll);

        System.out.println("from ArrayList<Double> to HashSet<Double>. Class: " + dHS.getClass().getName());
        System.out.println("HashSet<Double>: "+dHS);
    }
}
