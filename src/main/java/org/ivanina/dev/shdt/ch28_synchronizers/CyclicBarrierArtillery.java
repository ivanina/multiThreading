package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierArtillery implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String name;
    private boolean status;

    public CyclicBarrierArtillery(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        System.out.println("Artillery '"+name+"' preparing ballistic projectile");
        try {
            status = true;
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public boolean getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "Artillery "+name;
    }
}
