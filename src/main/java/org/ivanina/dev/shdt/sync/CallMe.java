package org.ivanina.dev.shdt.sync;

public class CallMe {
    /*synchronized*/ void call(String msg){
        System.out.print("[");
        try {
            Thread.sleep(500);
            System.out.print(msg);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("]");
    }
}
