package coding.algo.dp;

import coding.util.ArrayUtil;

import java.util.Arrays;

public class SubsetSum {

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

    static boolean isSubsetPresentLinear(int[] a,int sum){
        boolean dp[][]=new boolean[2][sum+1];
        dp[0][0]=dp[1][0]=true;
        for (int i = 1; i < sum+1; i++) {
            dp[0][i]=false;
        }

        for(int k=1;k<a.length;k++) {
            for (int j = 1; j < sum + 1; j++) {
                int i = (k % 2 == 0 ? 1 : 0);
                dp[k % 2][j] = a[k-1] > j ? dp[i][j] : (dp[i][j] || dp[i][j - a[k-1]]);
                ArrayUtil.print(dp);
                System.out.println();
            }
        }
//        ArrayUtil.print(dp);
        return dp[a.length%2][sum];
    }

    static int minCoins(int[] a, int v, int n){
        int dp[]=new int[v+1];
        for(int i=0;i<v+1;i++){
            dp[i]=i==0 ? 0 : Integer.MAX_VALUE;
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<v+1;j++){
                if(j>=a[i]){
                    if(dp[j-a[i]]!=Integer.MAX_VALUE){
                        dp[j]=Math.min(dp[j],dp[j-a[i]]+1);
                    }
                }
                //ArrayUtil.print(dp);
            }
        }
        return dp[v];
    }

    public static void main(String[] args) {
        int a[]=new int[]{1,34,4,2,5,7};
//        System.out.println(isSubsetPresent(a,13));
//        System.out.println(isSubsetPresentLinear(a,13));


        int coin[]=new int[]{25, 10, 5};
        System.out.println(minCoins(coin,50,coin.length));
    }
}
