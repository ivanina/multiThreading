package org.ivanina.dev.shdt.sync;

public class Caller implements Runnable {
    Thread thread;
    CallMe target;
    String msg;

    Caller(CallMe target, String msg){
        this.target = target;
        this.msg = msg;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (target){
            target.call(msg);
        }
    }
}
