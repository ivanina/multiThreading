package org.ivanina.dev.shdt.ch11_base;

public class DeadlockThread implements Runnable {
    Deadlock a;
    Deadlock b;
    Thread t;

    public DeadlockThread(Deadlock a, Deadlock b,  String threadName) {
        this.a = a;
        this.b = b;
        t = new Thread(this);
        t.setName(threadName);
        t.start();
    }

    @Override
    public void run(){
        a.foo(b);
    }
}
