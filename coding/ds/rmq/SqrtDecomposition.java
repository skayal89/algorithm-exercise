package coding.ds.rmq;

import java.util.Arrays;

public class SqrtDecomposition {
    int[] d;
    int r;

    public SqrtDecomposition(int a[]) {
        decomposeSum(a, a.length);
    }

    void decomposeSum(int a[], int n){
        r = (int) Math.ceil(Math.sqrt(n));
        d=new int[r];
        int j=-1; // used to fill the block

        for (int i = 0; i < n; i++) {
            if(i%r == 0){
                j++; // new block started, if current index of input array is divisible by block size
            }
            d[j]+=a[i];
        }
    }

    int sumQuery(int a[], int from, int to){
        int res=0;
        int i=0;
        int n=a.length;
        for (i=from;i%r != 0 && i <= to && i<n; i++) { // from is started from middle of a block
            res += a[i];
        }
        for (;i%r == 0 && i <= to && (to-i) >= r && i<n;i+=r){ // (to-i) >= r we can consider the whole block. Checkout for whiteboard pic
            res+=d[i/r];    // i%r == 0 starting of a block
        }
        for (;i<=to && i<n;i++){ // to is ending on a middle of a block
            res+=a[i];
        }
        return res;
    }

    void update(int a[], int index, int newValue){
        int diff=newValue-a[index];
        a[index]=newValue;
        d[index/r]+=diff;
    }

    public static void main(String[] args) {
        int a[]=new int[]{1,5,2,6,4,1,3,5,7};
        SqrtDecomposition decomposition=new SqrtDecomposition(a);
        System.out.println(Arrays.toString(decomposition.d));
        System.out.println(decomposition.sumQuery(a, 0,8));

        decomposition.update(a, 4, 7);
        System.out.println(Arrays.toString(decomposition.d));

        // test cases
        // (2,4), (2,7), (3,7), (2,8), (1,5), (3,8), (0,8), (0,18)
    }
}
