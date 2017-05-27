package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.CountDownLatch;

public class CDLBus {
    public CDLBus(int countPassengers) {
        try {
            System.out.println("I'm Bus. I'm waiting " + countPassengers + " passengers");
            CountDownLatch latch = new CountDownLatch(countPassengers);
            for (int i = 0; i < countPassengers; i++) {
                new CDLPassenger(latch, "men-" + (i + 1), (int) (Math.random() * 10) + 1);
            }
            latch.await();
            System.out.println("Finally!! Go!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
