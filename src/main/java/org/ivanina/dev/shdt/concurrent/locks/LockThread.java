package org.ivanina.dev.shdt.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LockThread implements Runnable {
    ReentrantLock lock;
    String name;

    public LockThread(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name+": waiting to lock 'counter'");
            lock.lock();
            System.out.println(name+": lock 'counter'");
            LockShared.cnt++;
            System.out.println(name+": "+LockShared.cnt);
            System.out.println(name+": waiting 2 sec");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e);
        }finally {
            System.out.println(name+": unlock 'counter'");
            lock.unlock();
        }

    }
}
