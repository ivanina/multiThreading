package org.ivanina.dev.shdt.lambda.base;

public class Lambda3BaseTempOps {
    boolean same(Lambda3BaseTemp temp1,Lambda3BaseTemp temp2){
        return temp2.hTemp == temp1.hTemp;
    }

    boolean lessThan(Lambda3BaseTemp temp1,Lambda3BaseTemp temp2){
        return temp1.hTemp < temp2.hTemp;
    }
}
