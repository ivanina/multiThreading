package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Phaser;

public class PhaserThread implements Runnable {
    Phaser phaser;
    String name;

    public PhaserThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name + ": start process #1");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println(name + " start process #2");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println(name + " start process #3");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println(name + " start process #4");
        phaser.arriveAndDeregister();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }
}
