package org.ivanina.dev.shdt.lambda.base;

public class Lambda2BaseDemo {
    public static void main(String[] args) {
        String out = stringOp(Lambda2BaseOps::strReverse,"Revers");
        System.out.println("This is Revers: " + out);

        String out2 = stringOp(Lambda2BaseOps::strUp,"Revers");
        System.out.println("This is Uppercase: " + out2);

        Lambda2BaseOps ops = new Lambda2BaseOps();
        String out22 = stringOp(ops::strReverse2,"Reverse-2");
        System.out.println("Reverse by exemplar: " + out22);


        //Non-static method cannot be referenced from a static context : 'Lambda2BaseOps::strReverse2'
        //System.out.println("Reverse 3: " + stringOp(Lambda2BaseOps::strReverse2,"Reverse-3"));
        System.out.println("Reverse 3: " + stringOp(new Lambda2BaseOps()::strReverse2,"Reverse-3"));

    }


    static String stringOp(Lambda2BaseFun<String> l, String str){
        return l.fun(str);
    }


}
