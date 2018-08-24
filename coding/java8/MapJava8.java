package coding.java8;

import java.util.*;

public class MapJava8 {
    public static void main(String[] args) {
        Map<Integer, Integer> m1=new HashMap<>();

        m1.merge(3, 1, (a, b) -> a + b);

        /*
        * Same as above merge
        Integer i=m1.get(3);
        if(i==null){
            m1.put(3,1);
        }
        else {
            m1.put(3,i+1);
        }
        */


    }
}
