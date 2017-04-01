package org.ivanina.dev.shdt.base;

/**
 * Created on 4/1/2017.
 */
public class Thread1RunnableDmo implements Runnable{
    Thread thread;
    Thread1RunnableDmo(String threadName){
        thread = new Thread(this,threadName);
        System.out.println(">> Child (1) thread is created: " + thread);
        thread.start();
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " child(1) thread. ");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(">>> Child (1) thread finished. "+thread);
    }
}
