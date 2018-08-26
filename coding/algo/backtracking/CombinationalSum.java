package coding.algo.backtracking;

import java.util.Arrays;

public class CombinationalSum {
    void sum(int a[], int n, int sum){
        int r[]=new int[n];
        Arrays.sort(a);
        sumUtil(a, 0, sum, r, 0);
    }

    void sumUtil(int a[], int i, int sum, int r[], int j)
    {
        if(sum<0)   return;
        if(sum==0){
            for (int k = 0; k < j; k++) {
                System.out.print(r[k] + " ");
            }
            System.out.println();
            return;
        }
        if(i<a.length && j<r.length) {
            r[j] = a[i];
            sumUtil(a, i, sum - a[i], r, j + 1);
            sumUtil(a, i + 1, sum, r, j);
        }
    }

    public static void main(String[] args) {
        int a[]=new int[]{4,6,2,8};
        int sum=8;
        new CombinationalSum().sum(a, a.length, sum);
    }
}
