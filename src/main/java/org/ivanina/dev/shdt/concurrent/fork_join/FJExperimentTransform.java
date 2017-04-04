package org.ivanina.dev.shdt.concurrent.fork_join;

public class FJExperimentTransform extends SqrtTransform {

    public FJExperimentTransform(double[] data, int start, int end) {
        super(data, start, end);
    }

    public FJExperimentTransform(double[] data, int start, int end, int seqThreshold) {
        super(data, start, end);
        this.seqThreshold = seqThreshold;
    }

    @Override
    protected void compute() {
        if(end - start < seqThreshold){
            for (int i = start; i < end; i++) {
                if(data[i] % 2 == 0){
                    data[i] = Math.sqrt(Math.random()*100/(int)Math.random()*10) ;
                }else{
                    data[i] = Math.cbrt(Math.random()*10000/(int)Math.random()*100) ;
                }
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
