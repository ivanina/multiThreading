package org.ivanina.dev.shdt.ch11_base;

public class ThreadIml implements Runnable, ThreadExtIml {
    Thread t;
    public ThreadIml(String name){
        t = new Thread(this);
        t.setName(name);
        // without start immediately
    }
    @Override
    public void run() {
        System.out.println("Start thread '"+t.getName()+"'");
        try {
            for (int i = 10 ; i > 0; i--){
                Thread.sleep(500);
                System.out.println(t.getName()+" to do ***");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("\nIn thread '"+t.getName()+"' all done");
    }

    public void start(){
        t.start();
    }

    @Override
    public boolean isAlive() {
        return t.isAlive();
    }

    @Override
    public Thread.State getState() {
        return t.getState();
    }

    public void join() throws InterruptedException {
        t.join();
    }
}
