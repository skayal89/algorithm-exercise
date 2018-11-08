package coding.algo.dp;

import coding.util.ArrayUtil;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int a[]=new int[]{3,14,5,2};
        int sum=7;
        System.out.println(isSubsetSumLinearSpace(a,sum));

        int k=0;
        System.out.println(k^1);
    }
}
