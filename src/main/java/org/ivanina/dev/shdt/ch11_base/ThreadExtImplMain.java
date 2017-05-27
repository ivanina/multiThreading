package org.ivanina.dev.shdt.ch11_base;

public class ThreadExtImplMain {
    public static void main(String[] args) {
        ThreadExt a = new ThreadExt("A-ext");
        ThreadExtIml b = new ThreadIml("B-impl");

        System.out.println("A. isAlive: "+ a.isAlive() + "("+a.getState()+")");
        System.out.println("B. isAlive: "+ b.isAlive() + "("+b.getState()+")");

        System.out.println("Start threads");
        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A. isAlive: "+ a.isAlive() + "("+a.getState()+")");
        System.out.println("B. isAlive: "+ b.isAlive() + "("+b.getState()+")");
    }
}
