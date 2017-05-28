package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Phaser;

public class PhaserMain {
    public static void main(String[] args) throws InterruptedException {
        int partiesWithoutMainThread = 3;
        Phaser phaser = new Phaser();
        phaser.register();
        int phase = 0;

        System.out.println("Start");
        char ch = 'A';
        for (int i =0 ; i < partiesWithoutMainThread; i++){
            new PhaserThread(phaser,ch++ +"");
        }

        for (int i =0 ; i < partiesWithoutMainThread; i++){
            phase = phaser.arriveAndAwaitAdvance();
            System.out.println(">> Phase #"+phase+" finished");
        }

        phaser.arriveAndDeregister();
        System.out.println("Process finished");

        if(phaser.isTerminated()){
            System.out.println("Phaser is terminated");
        }
    }
}
