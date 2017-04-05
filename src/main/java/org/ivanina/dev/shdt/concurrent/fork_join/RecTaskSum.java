package org.ivanina.dev.shdt.concurrent.fork_join;

import java.util.concurrent.RecursiveTask;

public class RecTaskSum extends RecursiveTask<Double> {
    double[] data;
    int start, end;
    int seqThreshold;

    public RecTaskSum(double[] data, int start, int end, int seqThreshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.seqThreshold = seqThreshold;
    }

    @Override
    protected Double compute() {
        double sum = 0.0;
        if(end-start < seqThreshold){
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        }else{
            int middle = (start + end) / 2;
            RecTaskSum taskSumA = new RecTaskSum(data,start,middle,seqThreshold);
            RecTaskSum taskSumB = new RecTaskSum(data,middle,end,seqThreshold);

            taskSumA.fork();
            taskSumB.fork();
            sum = taskSumA.join() + taskSumB.join();
        }
        return sum;
    }
}
