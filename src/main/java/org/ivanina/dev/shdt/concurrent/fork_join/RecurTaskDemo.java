package org.ivanina.dev.shdt.concurrent.fork_join;

import java.util.concurrent.ForkJoinPool;

public class RecurTaskDemo {
    public static void main(String[] args) {
        int seqThreshold = 1000;
        double[] data = new double[10000];
        double sum;
        ForkJoinPool fjp = new ForkJoinPool();

        for (int i = 0; i < data.length; i++) {
            data[i] = Math.random()*10;
            if(i%2==0){
                data[i] *= -1;
            }
        }
        sum = fjp.invoke(new RecTaskSum(data,0,data.length,seqThreshold));
        System.out.printf("Sum: %.4f",sum);
    }
}
