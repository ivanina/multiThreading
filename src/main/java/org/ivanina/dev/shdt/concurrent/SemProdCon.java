package org.ivanina.dev.shdt.concurrent;

public class SemProdCon {
    public static void main(String[] args) {
        SemProdConQuery query = new SemProdConQuery();
        new SemProdConConsumer(query);
        new SemProdConProducer(query);
    }
}
