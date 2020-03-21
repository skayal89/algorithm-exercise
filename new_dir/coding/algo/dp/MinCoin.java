package coding.algo.dp;

import coding.util.ArrayUtil;

import java.util.Arrays;

public class MinCoin {



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


        int coin[]=new int[]{25, 10, 5};
        System.out.println(minCoins(coin,50,coin.length));
    }
}
