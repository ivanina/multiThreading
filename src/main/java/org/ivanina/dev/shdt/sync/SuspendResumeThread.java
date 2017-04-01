package org.ivanina.dev.shdt.sync;

public class SuspendResumeThread implements Runnable {
    Thread thread;
    String name;
    boolean isSuspend;

    SuspendResumeThread(String name){
        this.name = name;
        thread = new Thread(this,name);
        System.out.println("new thread: "+thread);
        thread.start();
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i < 15; i++) {
                System.out.println(name+": "+i);
                Thread.sleep(200);
                synchronized (this){
                    while (isSuspend){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

    synchronized void suspend(){
        isSuspend = true;
    }
    synchronized void resume(){
        isSuspend = false;
        notify();
    }
}
