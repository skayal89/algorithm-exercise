package coding.algo.dp;

import coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSumLinearSpace {

    static boolean isSubsetSumLinearSpace(int a[], int sum){
        boolean dp[][]=new boolean[2][sum+1];
        for(int i=1;i<=sum;i++){
            dp[0][i]=false;
        }
        int k=1;
        dp[0][0]=true;
        dp[1][0]=true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[k][j]=j>=a[i] ? dp[k^1][j-a[i]] || dp[k][j] : dp[k^1][j];
            }
            k=k^1; // flip 0 to 1 and vice versa
            ArrayUtil.print(dp);
            System.out.println();
        }

        return dp[k^1][sum];
    }

    static boolean isSubsetPresent(int[] a,int sum){
        boolean dp[][]=new boolean[a.length+1][sum+1];
        for (int i = 1; i < sum+1; i++) {
            dp[0][i]=false;
        }
        for (int i = 0; i < a.length+1; i++) {
            dp[i][0]=true;
        }

        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j]=a[i-1]>j ? dp[i-1][j] : (dp[i-1][j] || dp[i-1][j-a[i-1]]);
            }
        }

        return dp[a.length][sum];
    }

    // Print all Subsets
    static void getAllSubsets(int a[], int n, int sum){
        getAllSubsetsUtil(a,n,sum,new int[a.length],0);
    }

    static void getAllSubsetsUtil(int a[], int n, int sum, int res[], int j){
        if(sum<0)   return;
        if(sum==0)  {
            for (int i = 0; i < j; i++) {
                System.out.print(res[i]+" ");
            }
            System.out.println();
            return;
        }
        if(n==0){
            return;
        }
        res[j]=a[n-1];
        getAllSubsetsUtil(a,n-1,sum-a[n-1],res,j+1);
        getAllSubsetsUtil(a,n-1,sum,res,j);
    }

    public static void main(String[] args) {
        int a[]=new int[]{3,14,5,2};
        int sum=7;
        System.out.println(isSubsetSumLinearSpace(a,sum));

        int k=0;
        System.out.println(k^1);


        int x[]=new int[]{2, 3, 5, 6, 8, 10};
        getAllSubsets(x,x.length,10);
        int y[]=new int[]{1, 2, 3, 4, 5};
        getAllSubsets(y,y.length,10);

    }
}
