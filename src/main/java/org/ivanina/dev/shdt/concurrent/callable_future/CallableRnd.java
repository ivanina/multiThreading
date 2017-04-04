package org.ivanina.dev.shdt.concurrent.callable_future;

import java.util.concurrent.Callable;

public class CallableRnd implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        return Math.random()*Math.random()*10000/Math.pow(Math.random(),Math.random());
    }
}
