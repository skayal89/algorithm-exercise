package coding.algo.backtracking;

import coding.util.ArrayUtil;

import java.util.Arrays;

public class CombinationalSum {
    void sum(int a[], int n, int sum){
        int r[]=new int[50];
        Arrays.sort(a);
        a=removeDuplicates(a); // if not removed then same o/p can be repeated multiple times
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

    int[] removeDuplicates(int a[]){
        int n=a.length;
        int k=1;
        for(int i=1;i<n;i++){
            if(a[i]!=a[i-1]){
                a[k++]=a[i];
            }
        }
        int b[]=new int[k];
        for(int j=0;j<k;j++){
            b[j]=a[j];
        }
        return b;
    }


    public static void main(String[] args) {
        int x[]=new int[]{1,2,2,2,3,4,4,4,4,4,5,5};
        x=new CombinationalSum().removeDuplicates(x);
        ArrayUtil.print(x);
        int a[]=new int[]{4,6,2,8};
        int sum=8;
        int b[]=new int[]{7,2,6,5};
        sum=16;
        b=new int[]{8, 1, 8, 6, 8};
        sum=12;
        new CombinationalSum().sum(b, b.length, sum);
    }
}
