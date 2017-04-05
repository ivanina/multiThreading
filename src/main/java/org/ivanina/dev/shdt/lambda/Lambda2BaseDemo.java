package org.ivanina.dev.shdt.lambda;

public class Lambda2BaseDemo {
    public static void main(String[] args) {
        String out = stringOp(Lambda2BaseOps::strReverse,"Revers");
        System.out.println("This is Revers: " + out);
        String out2 = stringOp(Lambda2BaseOps::strUp,"Revers");
        System.out.println("This is Uppercase: " + out2);
    }

    static String stringOp(Lambda2BaseFun<String> l, String str){
        return l.fun(str);
    }
}
