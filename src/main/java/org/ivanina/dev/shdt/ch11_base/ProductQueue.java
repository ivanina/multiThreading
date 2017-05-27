package org.ivanina.dev.shdt.ch11_base;

import java.util.ArrayList;
import java.util.List;

public class ProductQueue {
    private List<Product> products = new ArrayList<>();
    private boolean isReadyToGetProduct = false;

    synchronized public void putt(Product product){
        while (isReadyToGetProduct){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products.add(product);
        queueState();
        isReadyToGetProduct = true;
        notify();
    }

    synchronized public Product get(){
        Product p = null;
        try {
            while (!isReadyToGetProduct){
                wait();
            }
            p = products.remove( products.size()-1 );
        }catch (IndexOutOfBoundsException e){
            System.out.println(" **Queue** get-ERROR: Queue is empty");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            isReadyToGetProduct = false;
            queueState();
            notify();
            return p;
        }

    }

    private void queueState(){
        System.out.println("               .... now in Queue " + products.size() +" products");
    }
}
