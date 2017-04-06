package org.ivanina.dev.shdt.lambda.base;

public class Lambda4BaseGenericOps {
    static <T> int countMatch(T[] data, T v){
        int cnt = 0;
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(v)) cnt++;
        }
        return cnt;
    }
}
