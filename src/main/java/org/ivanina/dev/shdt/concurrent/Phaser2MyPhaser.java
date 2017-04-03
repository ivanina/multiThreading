package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Phaser;

public class Phaser2MyPhaser extends Phaser {
    int numPhases;

    public Phaser2MyPhaser( int parties, int numPhases) {
        super( parties);
        this.numPhases = numPhases;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Phase '"+phase+"' finished");
        return phase == numPhases || registeredParties == 0;
    }
}
