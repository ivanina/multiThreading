package org.ivanina.dev.shdt.ch28_synchronizers;

public class SemaphoreQueueRecipient implements Runnable {
    private SemaphoreQueue queue;

    public SemaphoreQueueRecipient(SemaphoreQueue queue) {
        this.queue = queue;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try{
            for(int i = 10 ; i > 0; i--){
                SemaphoreQueueProduct p = queue.get();
                System.out.println("     ... Recipient received product. "+p);
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
