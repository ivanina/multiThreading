package org.ivanina.dev.shdt.concurrent.fork_join;

import java.util.concurrent.ForkJoinPool;

public class SqrtTransformDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        double data[] = new double[10000000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (double) i;
        }

        System.out.println("\nSource:");
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f  ", data[i]);
        }

        SqrtTransform task = new SqrtTransform(data,0,data.length);
        fjp.invoke(task);
        //or and without 'ForkJoinPool fjp = new ForkJoinPool()'
        //task.invoke();

        System.out.println("\nResult:");
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f  ", data[i]);
        }
    }
}
