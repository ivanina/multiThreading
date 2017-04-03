package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);

        new CDLThread(latch,"A(3)");
        //new CDLThread(latch,"B(3)");

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main thread: "+ i);
                if(i==2) {
                    System.out.println("Main thread - CountDownLatch.await() ");
                    latch.await();
                }
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(">> Finish");
    }
}
