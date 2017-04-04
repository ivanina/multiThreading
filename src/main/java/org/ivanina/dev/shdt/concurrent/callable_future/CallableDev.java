package org.ivanina.dev.shdt.concurrent.callable_future;

import java.util.concurrent.Callable;

public class CallableDev implements Callable<Double> {
    int operations;

    public CallableDev(int operations) {
        this.operations = operations;
    }

    @Override
    public Double call() throws Exception {
        double dev = Math.random()*1000000;
        for (int i = 0; i < operations; i++) {
            dev /= Math.random()*10;
        }
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        return dev;
    }
}
