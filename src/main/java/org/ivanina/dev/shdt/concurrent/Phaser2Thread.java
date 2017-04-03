package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Phaser;

public class Phaser2Thread implements Runnable {
    Phaser phaser;
    String name;

    public Phaser2Thread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        this.phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()){
            System.out.println(name + ": start phase #"+phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
