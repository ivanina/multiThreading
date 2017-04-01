package org.ivanina.dev.shdt.sync;

public class DeadLock implements Runnable {
    DeadA a = new DeadA();
    DeadB b = new DeadB();

    DeadLock(){
        Thread.currentThread().setName("Main thread");
        new Thread(this,"Rival thread").start();

        // in main thread
        a.foo(b);
        System.out.println("a -> b");
    }
    @Override
    public void run() {
        b.bar(a);
        System.out.println("b -> a");
    }

    public static void main(String[] args) {
        new DeadLock();
    }


}
