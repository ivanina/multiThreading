package org.ivanina.dev.shdt.concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CBThread implements Runnable {
    CyclicBarrier cb;
    String name;

    public CBThread(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        try(InputStream is = (new URL("http://stackoverflow.com/")).openStream() ) {

            //cb.await();


            if( name.charAt(0)%2 == 0 ){
                System.out.println(name + " ooo");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String page;
                while ((page = br.readLine()) != null) {
                    double d = Math.sqrt( Math.random()*Math.random()/Math.random())*Math.random() / Math.abs(Math.random()*100) ;
                }
            }else{
                System.out.println(name + " ...");
            }

            System.out.println(name + " finished read");

            cb.await();
        }catch (InterruptedException | BrokenBarrierException  | IOException e ){
            System.out.println(e);
        }
    }
}
