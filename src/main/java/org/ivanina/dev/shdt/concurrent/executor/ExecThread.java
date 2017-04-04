package org.ivanina.dev.shdt.concurrent.executor;

import java.util.concurrent.CountDownLatch;

public class ExecThread implements Runnable {
    CountDownLatch latch;
    String name;

    public ExecThread(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
        System.out.println("  > start thread " + name);
        new Thread(this,name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name+": "+i);
            try {
                Thread.sleep(1000);
                latch.countDown();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
