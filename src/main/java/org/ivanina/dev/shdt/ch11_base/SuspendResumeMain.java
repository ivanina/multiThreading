package org.ivanina.dev.shdt.ch11_base;

public class SuspendResumeMain {
    public static void main(String[] args) {
        SuspendResumeThread thread = new SuspendResumeThread();
        try {
            for (int i = 1 ; i < 20 ; i++){
                System.out.println("*");
                if(i%10 == 0 ){
                    System.out.println("Requested resume thread");
                    thread.resume();
                }else if(i%5==0 ){
                    System.out.println("Requested suspend thread");
                    thread.suspend();
                }
                Thread.sleep(1000);
            }
            // for control
            thread.resume();

            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
