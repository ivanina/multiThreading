package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.CountDownLatch;

public class CDLThread implements Runnable {
    String name;
    CountDownLatch cdl;

    public CDLThread(CountDownLatch cdl, String name ) {
        this.cdl = cdl;
        this.name = name;
        new Thread(this,name).start();
        System.out.println("Start "+name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(100);
                cdl.countDown();
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
