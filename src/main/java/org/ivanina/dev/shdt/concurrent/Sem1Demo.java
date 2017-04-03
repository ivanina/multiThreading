package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Semaphore;

public class Sem1Demo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new Sem1IncSharedThread(sem,"A");
        new Sem1DecSharedThread(sem,"B");
    }
}
