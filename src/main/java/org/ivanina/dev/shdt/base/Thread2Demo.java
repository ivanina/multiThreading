package org.ivanina.dev.shdt.base;

public class Thread2Demo {
    public static void main(String ars[]){
        Thread2JoinDemo tA = new Thread2JoinDemo("A", Thread.MIN_PRIORITY);
        Thread2JoinDemo tB = new Thread2JoinDemo("B", Thread.MAX_PRIORITY);
        Thread2JoinDemo tC = new Thread2JoinDemo("C", Thread.MIN_PRIORITY);

        System.out.println("Thread A started: " + tA.thread.isAlive());
        System.out.println("Thread B started: " + tB.thread.isAlive());
        System.out.println("Thread C started: " + tC.thread.isAlive());

        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println("main: "+i);
                if(i == 2){
                    System.out.println("Waiting for threads to finish");
                    tA.thread.join();
                    tB.thread.join();
                    tC.thread.join();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread A started: " + tA.thread.isAlive());
        System.out.println("Thread B started: " + tB.thread.isAlive());
        System.out.println("Thread C started: " + tC.thread.isAlive());

        System.out.println(">>> MAIN is Finished. "+Thread.currentThread());

    }
}
