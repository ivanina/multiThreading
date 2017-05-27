package org.ivanina.dev.shdt.ch11_base;

public class Product {
    private String sku;

    public Product(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString(){
        return "sku: "+sku;
    }
}
