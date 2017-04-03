package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Semaphore;

public class SemProdConQuery {
    int n = 0;
    Semaphore semProducer = new Semaphore(1);
    Semaphore semConsumer = new Semaphore(0);

    void get(){
        try {
            semConsumer.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("received: "+ n);
        semProducer.release();
    }

    void put(int n){
        try {
            semProducer.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.n = n;
        System.out.println("Put: "+ n);
        semConsumer.release();
    }
}
