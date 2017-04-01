package org.ivanina.dev.shdt.sync;

public class Store {
    public static void main(String[] args) {
        StoreQuery q = new StoreQuery();
        StoreProducer producer = new StoreProducer(q);
        StoreConsumer consumer = new StoreConsumer(q);

        try {
            Thread.sleep(2000);
            producer.thread.interrupt();
            consumer.thread.interrupt();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(">>> MAIN finished");
    }
}
