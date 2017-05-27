package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrierHeadquartersControl headquarters = new CyclicBarrierHeadquartersControl();
        int parties = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, headquarters );

        for(int i = 0; i < parties*3; i++){
            CyclicBarrierArtillery a = new CyclicBarrierArtillery(cyclicBarrier, String.valueOf((char) ('A'+i)));
            headquarters.add(a);
            Thread.sleep(500);
        }

    }
}
