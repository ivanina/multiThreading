package org.ivanina.dev.shdt.ch28_synchronizers;

public class SemaphoreQueueProduct {
    private String sku;

    public SemaphoreQueueProduct(String sku) {
        this.sku = sku;
    }
    public SemaphoreQueueProduct() {
        this.sku = System.currentTimeMillis()+"";
    }

    @Override
    public String toString(){
        return "SKU: "+sku;
    }
}
