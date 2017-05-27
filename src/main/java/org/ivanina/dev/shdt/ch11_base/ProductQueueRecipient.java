package org.ivanina.dev.shdt.ch11_base;

public class ProductQueueRecipient implements Runnable {
    ProductQueue queue;

    public ProductQueueRecipient(ProductQueue queue) {
        this.queue = queue;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < 10 ; i++){
                Thread.sleep(300);
                Product p = queue.get();
                if(p != null){
                    System.out.println(" > Recipient: Receive product "+ p);
                }else {
                    System.out.println(" > Recipient: Cannot receive product :(");
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Recipient finished");
    }
}
