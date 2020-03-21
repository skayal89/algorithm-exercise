package coding.algo.dp;

public class OptimalStrategyForGame {

    static int strategy(int a[]){
        int n=a.length;
        int dp[][]=new int[n][n];
        int j,x,y,z;

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                j=i+l-1;

                x=(i+2)<=j ? dp[i+2][j] : 0;
                y=(i+1)<=(j-1) ? dp[i+1][j-1] : 0;
                z=i<=(j-2) ? dp[i][j-2] : 0;

                dp[i][j]=Math.max(a[i]+Math.min(x,y),a[j]+Math.min(y,z));
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int a[]=new int[]{8,15,3,7};
        int b[]=new int[]{5, 3, 7, 10};
        System.out.println(strategy(a));
        System.out.println(strategy(b));
    }
}
