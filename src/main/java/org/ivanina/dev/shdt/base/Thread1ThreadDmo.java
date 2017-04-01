package org.ivanina.dev.shdt.base;


public class Thread1ThreadDmo extends Thread {
    Thread1ThreadDmo(String threadName){
        super(threadName);
        System.out.println(">> Child (2) thread is created. "+this);
        start();
    }

    public void run(){
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " child(2) thread. ");
                Thread.sleep(700);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(">>> Child (2) thread is Finished. "+this.getName());
    }
}
