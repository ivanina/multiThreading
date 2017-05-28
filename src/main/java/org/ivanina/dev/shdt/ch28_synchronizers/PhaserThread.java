package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Phaser;

public class PhaserThread implements Runnable {
    private Phaser phaser;
    private String name;
    private int speed = 5;

    public PhaserThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        this.phaser.register();
        speed = (int)(Math.random()*10)+1;
        new Thread(this,name).start();
    }

    @Override
    public void run() {

        for (int i = 0 ; i < phaser.getRegisteredParties() ; i++){
            phase(i+1);
        }
    }

    private void phase(int number){
        try {
            System.out.println(" -> "+name+" start phase #"+number);
            for (int i = 3; i > 0; i--){
                System.out.println("      .... todo-todo-todo: "+name+"["+number+"(speed:"+speed+")|"+i+"]");
                Thread.sleep(10000 / speed);
            }
            phaser.arriveAndAwaitAdvance();
            Thread.sleep(50);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
