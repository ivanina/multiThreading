package org.ivanina.dev.shdt.lambda.base;

class Lambda3BaseTemp {
    int  hTemp;

    public Lambda3BaseTemp(int hTemp) {
        this.hTemp = hTemp;
    }

    boolean same(Lambda3BaseTemp temp){
        return hTemp == temp.hTemp;
    }

    boolean lessThan(Lambda3BaseTemp temp){
        return hTemp < temp.hTemp;
    }
}
