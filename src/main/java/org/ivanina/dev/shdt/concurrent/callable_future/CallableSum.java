package org.ivanina.dev.shdt.concurrent.callable_future;

import java.util.concurrent.Callable;

public class CallableSum implements Callable<Double> {
    int operations;

    public CallableSum(int operations) {
        this.operations = operations;
    }

    @Override
    public Double call() throws Exception {
        double sum = 0.0;
        for (int i = 0; i < operations; i++) {
            sum += Math.random()*10;
        }
        return sum;
    }
}
