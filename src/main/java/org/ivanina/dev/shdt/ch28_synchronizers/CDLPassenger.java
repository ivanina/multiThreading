package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.CountDownLatch;

public class CDLPassenger implements Runnable {
    private String name;
    private int speed;
    CountDownLatch latch;

    public CDLPassenger(CountDownLatch latch, String name, int speed) {
        this.latch = latch;
        this.name = name;
        this.speed = speed;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            for(int i = 5; i > 0; i--){
                System.out.println(name+": I'm running... [step:"+i+" | speed:"+speed+"]");
                Thread.sleep( 10000 / speed );
            }
            System.out.println(">> "+name+": I'm ran!");
            latch.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
