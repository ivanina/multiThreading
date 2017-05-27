package org.ivanina.dev.shdt.ch11_base;

public class DeadlockMain {
    public static void main(String[] args) {
        Deadlock a = new DeadlockSrcA();
        Deadlock b = new DeadlockSrcB();

        DeadlockThread thread1 = new DeadlockThread(a,b,"Thread 1");
        DeadlockThread thread2 = new DeadlockThread(b,a,"Thread 2");

    }
}
