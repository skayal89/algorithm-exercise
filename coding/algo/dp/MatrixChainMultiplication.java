package coding.algo.dp;

import coding.util.ArrayUtil;

public class MatrixChainMultiplication {
    
    static int minMultiplicationCost(int m[]){
        int n=m.length;
        int dp[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i]=0;
        }
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j=i+l-1;
                for (int k = i; k < j; k++) {
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+m[i-1]*m[k]*m[j]);
                }
            }
        }
        System.out.println();
        ArrayUtil.print(dp);
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int m[]=new int[]{40,20,30,10,30};
        System.out.println(minMultiplicationCost(m));
    }
}
