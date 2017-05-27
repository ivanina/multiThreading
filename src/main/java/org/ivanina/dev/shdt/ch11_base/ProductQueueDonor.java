package org.ivanina.dev.shdt.ch11_base;

public class ProductQueueDonor implements Runnable {
    ProductQueue queue;

    public ProductQueueDonor(ProductQueue queue) {
        this.queue = queue;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10 ; i++){
                Thread.sleep(700);
                Product p = new Product( System.currentTimeMillis()+"" );
                System.out.println("<- Donor :: put product: " + p);
                queue.putt( p );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Donor finished");
    }
}
