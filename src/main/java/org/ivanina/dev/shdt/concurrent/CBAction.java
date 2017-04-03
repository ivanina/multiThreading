package org.ivanina.dev.shdt.concurrent;

public class CBAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier reached. Action!");
    }
}
