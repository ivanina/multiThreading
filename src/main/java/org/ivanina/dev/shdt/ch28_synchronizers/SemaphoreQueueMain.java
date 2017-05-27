package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreQueueMain {
    public static void main(String[] args) {
        Semaphore semaphoreDonor = new Semaphore(1);
        Semaphore semaphoreRecipient = new Semaphore(0);
        SemaphoreQueue productQueue = new SemaphoreQueue(semaphoreDonor,semaphoreRecipient);

        new SemaphoreQueueRecipient(productQueue);
        new SemaphoreQueueDonor(productQueue);
    }
}
