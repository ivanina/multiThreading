package org.ivanina.dev.shdt.lambda.base;

public class Lambda4BaseGenericDemo {
    public static void main(String[] args) {
        Integer[] ints = {1,2,1,2,3,4,3,4,4,4,5,6,5,4,4};
        String[] strs = {"2","2","3","4","5","6","4","4","7","8","9","one","one","one","tow",};

        System.out.println("Ints same 4: "+
                ops(Lambda4BaseGenericOps::<Integer>countMatch,ints,4)
        );
        System.out.println("String same \"one\": "+
                ops(Lambda4BaseGenericOps::<String>countMatch,strs,"one")
        );

        //without generic (automatically)
        System.out.println("(auto)Ints same 4: " + ops(Lambda4BaseGenericOps::countMatch,ints,4));
        System.out.println("(auto)String same \"one\": " + ops(Lambda4BaseGenericOps::countMatch,strs,"one"));
    }

    static <T> int ops(Lambda4BaseGenericFun<T> l, T[] data, T v){
        return l.fun(data,v);
    }
}
