package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreQueue {
    private List<SemaphoreQueueProduct> products = new ArrayList<>();

    private Semaphore semaphoreDonor;
    private Semaphore semaphoreRecipient;

    public SemaphoreQueue(Semaphore semaphoreDonor, Semaphore semaphoreRecipient) {
        this.semaphoreDonor = semaphoreDonor;
        this.semaphoreRecipient = semaphoreRecipient;
    }

    public void put(SemaphoreQueueProduct product){
        try {
            semaphoreDonor.acquire();
            System.out.println("-> new product added. "+product);
            products.add(product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphoreRecipient.release();
    }
    public SemaphoreQueueProduct get(){
        SemaphoreQueueProduct p = null;
        try {
            semaphoreRecipient.acquire();
            if(products.size() == 0) {
                System.out.println("!! ERROR: Queue is empty ");
            }else {
                p = products.remove( products.size()-1 );
                System.out.println("<- product sent. "+p);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreDonor.release();
            return p;
        }
    }
    public int getSize(){
        return products.size();
    }
}
