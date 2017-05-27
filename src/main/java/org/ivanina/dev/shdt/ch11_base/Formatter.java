package org.ivanina.dev.shdt.ch11_base;

public class Formatter {
    private String msg;

    public Formatter(String msg) {
        this.msg = msg;
    }

    public Formatter() {}

    synchronized public void call(String msg){
        System.out.print("\noutput: ");
        try {
            System.out.print("[");
            Thread.sleep(500);
            System.out.print(msg);
            Thread.sleep(500);
            System.out.print("]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".");
    }

    public void call(){
        System.out.println("["+msg+"]");
    }

}
