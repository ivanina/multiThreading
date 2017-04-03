package org.ivanina.dev.shdt.concurrent;

public class Phaser2Demo {
    public static void main(String[] args) {
        Phaser2MyPhaser phaser = new Phaser2MyPhaser(1,5);
        System.out.println(">> Start threads");

        new Phaser2Thread(phaser,"A");
        new Phaser2Thread(phaser,"B");
        new Phaser2Thread(phaser,"C");

        while (!phaser.isTerminated()){
            phaser.arriveAndAwaitAdvance();
        }
        System.out.println("<<< Finished");
    }
}
