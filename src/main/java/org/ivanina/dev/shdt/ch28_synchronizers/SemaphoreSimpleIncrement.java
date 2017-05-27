package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreSimpleIncrement implements Runnable {
    Semaphore semaphore;
    SemaphoreSimpleShared counter;

    public SemaphoreSimpleIncrement(Semaphore semaphore, SemaphoreSimpleShared counter) {
        this.semaphore = semaphore;
        this.counter = counter;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 10; i > 0; i--){
                counter.increment();
                System.out.println("Increment Thread: counter = "+counter.getCounter());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        semaphore.release();
    }
}
