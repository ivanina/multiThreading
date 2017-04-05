package org.ivanina.dev.shdt.lambda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lambda1BaseDemo {
    public static void main(String[] args) {
        Lambda1BaseMyNum num;
        num = () -> Math.floor( Math.random()*10);
        System.out.println("RND: "+num.getValue());

        num = () -> Math.PI;
        System.out.println("PI: "+ new BigDecimal(num.getValue()).setScale(4, RoundingMode.FLOOR));

        Lambda1BaseTest test;
        test = (a, b) -> a == b;
        System.out.println("3 gt; 7? "+test.test(3,7));

        test = ((a, b) -> {
            a = a<<(int)Math.random()*10;
            b = b>>(int)Math.random()*10;
            return a>b;
        });
        System.out.println("Random gt; "+test.test(2,5));

        //Revers with generic
        Lambda1BaseGenericFun<String> fun = (str)->{
            StringBuffer sb = new StringBuffer();
            for (int i = str.length()-1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            return sb.toString();
        };
        System.out.println("'This is test' >< "+fun.fun("This is test"));

        Lambda1BaseGenericFun<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("Factorial 3: " + factorial.fun(4));

        System.out.println("As argument. Uppercase: " + stringFun((str)->{
            return str.toUpperCase();
        },"Uppercase"));

    }

    static String suffix = "!";
    static String stringFun(Lambda1BaseAsArg<String> l, String str){
        return l.fun(str)+suffix;
    }
}
