package org.ivanina.dev.shdt.ch11_base;

public class SuspendResumeThread implements Runnable {
    private boolean isSuspend;
    private Thread t;

    public SuspendResumeThread(){
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        try{
            for (int i = 20 ; i > 0; i-- ){
                Thread.sleep(500);
                System.out.println("- todo.....");
                synchronized (this){
                    while (isSuspend){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(">> Finished");
    }

    synchronized public void suspend() throws InterruptedException {
        isSuspend = true;
        System.out.println("thread suspended");
    }

    synchronized public void resume(){
        if(isSuspend){
            isSuspend = false;
            System.out.println("thread resumed");
            notify();
        }
    }

    public void join() throws InterruptedException {
        t.join();
    }
}
