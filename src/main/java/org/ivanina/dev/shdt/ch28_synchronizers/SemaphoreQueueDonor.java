package org.ivanina.dev.shdt.ch28_synchronizers;

public class SemaphoreQueueDonor implements Runnable {
    private SemaphoreQueue queue;

    public SemaphoreQueueDonor(SemaphoreQueue queue) {
        this.queue = queue;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try{
            for(int i = 10 ; i > 0; i--){
                queue.put(new SemaphoreQueueProduct());
                Thread.sleep(3000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
