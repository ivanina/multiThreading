package org.ivanina.dev.shdt.concurrent;

public class SemProdConProducer implements Runnable {
    SemProdConQuery q;

    public SemProdConProducer(SemProdConQuery q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q.put(i);
        }
    }
}
