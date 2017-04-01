package org.ivanina.dev.shdt.sync;

public class SuspendResume {
    public static void main(String[] args) {
        SuspendResumeThread threadA = new SuspendResumeThread("A");
        SuspendResumeThread threadB = new SuspendResumeThread("B");

        try {
            Thread.sleep(1000);
            threadA.suspend();
            System.out.println("Tread A suspended");
            Thread.sleep(1000);
            threadA.resume();
            System.out.println("Tread A resumed");

            Thread.sleep(1000);
            threadB.suspend();
            System.out.println("Tread B suspended");
            Thread.sleep(1000);
            threadB.resume();
            System.out.println("Tread B resumed");

            System.out.println("Waiting finish child threads");
            threadA.thread.join();
            threadB.thread.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(">>> MAIN thread finished");
    }
}
