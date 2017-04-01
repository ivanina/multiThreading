package org.ivanina.dev.shdt.sync;

public class CallerSyncDeo {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller tA = new Caller(target,"Thread A");
        Caller tB = new Caller(target,"Thread B");
        Caller tC = new Caller(target,"Thread C");

        try {
            tA.thread.join();
            tB.thread.join();
            tC.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>> MAIN finished");
    }
}
