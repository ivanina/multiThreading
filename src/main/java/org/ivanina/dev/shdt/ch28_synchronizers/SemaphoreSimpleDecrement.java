package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreSimpleDecrement implements Runnable {
    Semaphore semaphore;
    SemaphoreSimpleShared counter;

    public SemaphoreSimpleDecrement(Semaphore semaphore, SemaphoreSimpleShared counter) {
        this.semaphore = semaphore;
        this.counter = counter;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 10; i > 0; i--){
                counter.decrement();
                System.out.println("Decrement Thread: counter = "+counter.getCounter());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        semaphore.release();
    }
}
