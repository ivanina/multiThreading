package org.ivanina.dev.shdt.concurrent.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);

        System.out.println(">> start threads");
        es.execute( new ExecThread( cdl1, "A") );
        es.execute( new ExecThread( cdl2, "B") );
        es.execute( new ExecThread( cdl3, "C") );
        es.execute( new ExecThread( cdl4, "D") );

        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        es.shutdown();
        System.out.println(">>> Main finished");
    }
}
