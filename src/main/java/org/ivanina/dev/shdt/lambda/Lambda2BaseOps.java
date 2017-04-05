package org.ivanina.dev.shdt.lambda;

public class Lambda2BaseOps {
    static String strReverse(String str){
        StringBuffer sb = new StringBuffer();
        for (int i = str.length()-1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    static String strUp(String str){
        return str.toUpperCase();
    }
}
