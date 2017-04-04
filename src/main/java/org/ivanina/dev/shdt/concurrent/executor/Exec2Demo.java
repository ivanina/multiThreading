package org.ivanina.dev.shdt.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exec2Demo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.execute(new Exec2Thread("A"));
        es.execute(new Exec2Thread("B"));
        es.execute(new Exec2Thread("C"));
        es.execute(new Exec2Thread("D"));
        es.execute(new Exec2Thread("I"));

        es.shutdown();
        System.out.println("___ main finished ___");
    }
}
