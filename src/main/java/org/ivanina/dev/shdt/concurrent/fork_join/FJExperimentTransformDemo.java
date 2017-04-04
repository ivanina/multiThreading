package org.ivanina.dev.shdt.concurrent.fork_join;

import java.util.concurrent.ForkJoinPool;

public class FJExperimentTransformDemo {
    public static void main(String[] args) {
        long beginT, endT;
        int threshold = 100;
        int pLevel = 5;

        double data[] = new double[10000000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (double) i;
        }
        beginT = System.nanoTime();
        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        FJExperimentTransform task = new FJExperimentTransform(data,0,data.length,threshold);
        fjp.invoke(task);
        endT = System.nanoTime();

        System.out.println("Threshold: "+threshold);
        System.out.println("Level:     "+pLevel);
        System.out.println("Time (ns): "+(endT-beginT));
    }
}
