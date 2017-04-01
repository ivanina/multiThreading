package org.ivanina.dev.shdt.sync;

public class StoreConsumer implements Runnable {
    Thread thread;
    StoreQuery q;
    StoreConsumer(StoreQuery q){
        this.q = q;
        thread = new Thread(this,"StoreConsumer");
        thread.start();
    }

    @Override
    public void run(){
        try {
            while (true){
                q.get();
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }
}
