package org.ivanina.dev.shdt.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock,"A");
        new LockThread(lock,"B");
        new LockThread(lock,"C");
    }
}
