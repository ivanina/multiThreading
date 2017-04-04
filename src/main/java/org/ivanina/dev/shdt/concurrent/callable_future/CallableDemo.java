package org.ivanina.dev.shdt.concurrent.callable_future;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        System.out.println(" >> start");
        Future<Double> f1sum = es.submit(new CallableSum(5));
        Future<Double> f2dev = es.submit(new CallableDev(2));
        Future<Double> f3rnd = es.submit(new CallableRnd());

        try {
            System.out.println("sum: " + f1sum.get());
            System.out.println("dev: " + f2dev.get(10, TimeUnit.SECONDS));
            System.out.println("rnd: " + f3rnd.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println(" >> main finished");
    }
}
