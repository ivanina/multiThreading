package org.ivanina.dev.shdt.concurrent.fork_join;

import java.util.concurrent.RecursiveAction;

public class SqrtTransform extends RecursiveAction {
    double[] data;
    int start, end;
    int seqThreshold = 1000;

    public SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end - start < seqThreshold){
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        }else {
            int middle = (start + end) / 2;
            invokeAll(
                    new SqrtTransform(data,start,middle),
                    new SqrtTransform(data,middle,end)
                    );
        }
    }
}
