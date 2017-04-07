package org.ivanina.dev.shdt.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Stream3IteratorSpliterator {
    public static void main(String[] args) {
        ArrayList<Integer> iList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            iList.add(ThreadLocalRandom.current().nextInt(1, 100));
        }

        Stream<Integer> iStream = iList.stream();
        Iterator<Integer> iterator = iStream.iterator();
        System.out.println("In while loop:");
        while (iterator.hasNext()){
            System.out.print(iterator.next()+", ");
        }

        System.out.println("\nIn while loop with Spliterator:");
        Spliterator<Integer> spliterator = iList.spliterator();
        while (spliterator.tryAdvance(n -> System.out.print(n+", ")));

        System.out.println("\nSpliterator with forEachRemaining:");
        iList.spliterator().forEachRemaining(n -> System.out.print(n+", "));
    }
}
