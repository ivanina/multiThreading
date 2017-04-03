package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Semaphore;

public class Sem1IncSharedThread implements Runnable{
    Semaphore sem;
    String name;

    public Sem1IncSharedThread(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        System.out.println(name + " started");
        try{
            System.out.println(name + " awaits permission");
            sem.acquire();
            System.out.println(name + " received permission");
            for (int i = 0; i < 5; i++) {
                Sem1Shared.count ++;
                System.out.println(name + ": " + Sem1Shared.count);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " release permission");
        sem.release();
    }
}
