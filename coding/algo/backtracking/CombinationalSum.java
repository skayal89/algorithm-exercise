package coding.algo.backtracking;

import java.util.Arrays;

public class CombinationalSum {
    void sum(int a[], int n, int sum){
        int r[]=new int[n];
        Arrays.sort(a);
        sumUtil(a, 0, sum, r, 0);
    }

    void sumUtil(int a[], int i, int sum, int results[], int j)
    {
        if(sum<0)   return;
        if(sum==0){
            for (int k = 0; k < j; k++) { // print the result & return
                System.out.print(results[k] + " ");
            }
            System.out.println();
            return;
        }
        if(i<a.length && j<results.length) {
            results[j] = a[i];
            sumUtil(a, i, sum - a[i], results, j + 1); // include the element
            sumUtil(a, i + 1, sum, results, j); // exclude the element
        }
    }

    public static void main(String[] args) {
        int a[]=new int[]{4,6,2,8};
        int sum=8;
        new CombinationalSum().sum(a, a.length, sum);
    }
}
