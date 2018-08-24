package coding.java8;

import java.util.ArrayList;
import java.util.Arrays;

public class ComparatorExample {
    public static void main(String[] args) {
        Integer a[]=new Integer[]{3,5,1,8,9,4,3};
        Arrays.sort(a, (x,y)->y-x); // define Comparator in Java 8 way
        Arrays.stream(a).forEach(System.out::println);


    }


}
