package org.ivanina.dev.shdt.concurrent;

public class SemProdConConsumer implements Runnable {
    SemProdConQuery q;

    public SemProdConConsumer(SemProdConQuery q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            q.get();
        }
    }
}
