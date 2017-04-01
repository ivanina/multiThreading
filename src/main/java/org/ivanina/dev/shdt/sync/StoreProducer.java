package org.ivanina.dev.shdt.sync;

public class StoreProducer implements Runnable {
    Thread thread;
    StoreQuery q;
    StoreProducer(StoreQuery q){
        this.q = q;
        thread =new Thread(this,"StoreProducer");
        thread.start();
    }
    @Override
    public void run() {
        int i = 0;
        try {
            while (true){
                q.put(i++);
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }
}
