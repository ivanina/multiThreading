package org.ivanina.dev.shdt.ch11_base;

public class CheckSynchMethods implements Runnable {
    Thread t;
    public CheckSynchMethods(){
        t = new Thread(this);
        t.start();
    }

    public static void main(String[] args) {
        CheckSynchMethods check1 = new CheckSynchMethods();
        CheckSynchMethods check2 = new CheckSynchMethods();

        check2.foo(check1);
        try {
            check1.join();
            check2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("It's correct");
    }

    @Override
    public void run() {
        System.out.println("Start..");
        this.methodA();
    }

    synchronized private void methodA(){
        System.out.println("In method A");
        this.methodB();
    }

    synchronized private void methodB(){
        System.out.println("In method B");
    }


    //-----------------
    synchronized private void foo(CheckSynchMethods thread){
        System.out.println("Try call bar");
        thread.bar();
    }

    synchronized private void bar(){
        System.out.println(" I am bar ");
    }

    public void join() throws InterruptedException {
        t.join();
    }
}
