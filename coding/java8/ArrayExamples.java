package coding.java8;

import java.util.Arrays;

public class ArrayExamples {

    public static void main(String[] args) {
        int a[]=new int[]{5,4,1,9,8,7,6};

        int b[]=new int[]{0,1,1,0,1,0,1};
        System.out.println(countOne(b));
    }

    static int min(int a[]){
        return Arrays.stream(a).min().getAsInt();
    }

    static int max(int a[]){
        return Arrays.stream(a).max().getAsInt();
    }

    static int sum(int a[]){
        return Arrays.stream(a).sum();
    }

    static double avg(int a[]){
        return Arrays.stream(a).average().getAsDouble();
    }

    static long aboveAverage(int a[]){
        return Arrays.stream(a).filter(i -> i>avg(a)).count();
    }

    static long countOne(int a[]){
        return Arrays.stream(a).filter(i -> i==1).count();
    }
}
