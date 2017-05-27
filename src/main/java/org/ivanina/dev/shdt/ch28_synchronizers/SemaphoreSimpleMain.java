package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreSimpleMain {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        SemaphoreSimpleShared shared = new SemaphoreSimpleShared();

        new SemaphoreSimpleIncrement(semaphore,shared);
        new SemaphoreSimpleDecrement(semaphore,shared);

    }
}
