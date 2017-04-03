package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int no = 0;

        System.out.println("Start");
        new PhaserThread(phaser,"A");
        new PhaserThread(phaser,"B");
        new PhaserThread(phaser,"C");

        no = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase no.: " +no+ " finished");

        no = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase no.: " +no+ " finished");

        no = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase no.: " +no+ " finished");

        no = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase no.: " +no+ " finished");

        phaser.arriveAndDeregister();

        if(phaser.isTerminated()){
            System.out.println("<< All phases finished");
        }
        System.out.println("<<< MAIN finished");
    }
}
