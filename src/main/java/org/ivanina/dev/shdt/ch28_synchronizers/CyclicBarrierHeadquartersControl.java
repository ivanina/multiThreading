package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class CyclicBarrierHeadquartersControl implements Runnable {
    private Set<CyclicBarrierArtillery> artillery = new HashSet<>();

    public void add(CyclicBarrierArtillery item){
        artillery.add(item);
    }

    synchronized public void fire(){
        System.out.print("\n** Attention -> FIRE : ");
        Set<CyclicBarrierArtillery> ready = new HashSet<>();
        for(CyclicBarrierArtillery item : artillery){
            if(item.getStatus()) {
                System.out.print(item+", ");
                ready.add(item);
            }
        }
        artillery.removeAll(ready);
        System.out.println("\n");
    }

    @Override
    public void run() {
        fire();
    }
}
