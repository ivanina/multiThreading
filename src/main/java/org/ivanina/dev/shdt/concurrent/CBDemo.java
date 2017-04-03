package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CBDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new CBAction());
        System.out.println("MAIN: start threads");
        new CBThread(cb,"A");
        new CBThread(cb,"B");
        new CBThread(cb,"C");
        new CBThread(cb,"D");
        new CBThread(cb,"I");
        new CBThread(cb,"F");
    }
}
