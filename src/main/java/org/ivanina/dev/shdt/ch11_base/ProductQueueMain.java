package org.ivanina.dev.shdt.ch11_base;

public class ProductQueueMain {
    public static void main(String[] args) {
        ProductQueue queue = new ProductQueue();

        ProductQueueDonor donor = new ProductQueueDonor(queue);
        ProductQueueRecipient recipient = new ProductQueueRecipient(queue);
    }
}
