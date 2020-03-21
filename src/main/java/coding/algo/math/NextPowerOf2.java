package coding.algo.math;

public class NextPowerOf2 {

    public static int getNext(int n){
        int r=1;
        if(n>0 && (n & (n-1))==0){
            return n;
        }

        while (r<n){
            r <<= 1;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(getNext(6));
    }
}
