package org.ivanina.dev.shdt.ch11_base;

public class ThreadExt extends Thread implements ThreadExtIml {
    public ThreadExt(String name){
        this.setName(name);
    }
    @Override
    public void run() {
        System.out.println("Start thread '"+getName()+"'");
        try {
            for (int i = 0 ; i < 10; i++){
                Thread.sleep(500);
                System.out.println(getName()+" to do ...");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("\nIn thread '"+getName()+"' all done");
    }
}
