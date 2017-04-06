package org.ivanina.dev.shdt.lambda.base;

public class Lambda3BaseTempDemo {
    public static void main(String[] args) {
        Lambda3BaseTemp[] data = {
                new Lambda3BaseTemp(12),
                new Lambda3BaseTemp(23),
                new Lambda3BaseTemp(18),
                new Lambda3BaseTemp(22),
                new Lambda3BaseTemp(18),
                new Lambda3BaseTemp(12),
                new Lambda3BaseTemp(4),
        };

        int cnt1 = counter(data,Lambda3BaseTemp::same,new Lambda3BaseTemp(12));
        System.out.println("Same as 12: "+cnt1);

        // !!!
        int cnt2 = counter(data,new Lambda3BaseTempOps()::same,new Lambda3BaseTemp(23));
        System.out.println("Same as 23: "+cnt2);

        int cnt3 = counter(data,Lambda3BaseTemp::lessThan,new Lambda3BaseTemp(18));
        System.out.println("Less than 18: "+cnt3);
    }

    static <T> int counter(T[] data, Lambda3BaseTempFun<T> l, T v){
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if(l.fun(data[i],v)) count++;
        }
        return count;
    }
}
