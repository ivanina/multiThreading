package org.ivanina.dev.shdt.ch11_base;

public class StopBeforeMain {
    public static void main(String[] args) {
        StopBeforeThread a = new StopBeforeThread("A",10);
        StopBeforeThread b = new StopBeforeThread("B",5);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is done");
    }
}
