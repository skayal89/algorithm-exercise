package coding.algo.dp;

/*
 * https://stackoverflow.com/questions/32818613/number-of-ways-to-divide-a-number
 * Walmart
 */
public class WaysToDivideNumber {

    static int waysRecursive(int n, int k){
        if(k<=1)    return 1;
        if(k>n || (n>0 && k==0))    return 0; // invalid input
        return waysRecursive(n-k, k) + waysRecursive(n-1,k-1);
    }

    static int waysDPTopDown(int dp[][], int n, int k){
        if(k<=1)    return 1;
        if(k>n || (n>0 && k==0))    return 0; // invalid input
        if(dp[n][k]!=-1)    return dp[n][k];
        return dp[n][k] = waysDPTopDown(dp,n-k, k) + waysDPTopDown(dp,n-1,k-1);
    }

    static int waysTopDown(int n, int k){
        int dp[][]=new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            for (int j=0;j<=k;j++){
                dp[i][j]=-1;
            }
        }
        return waysDPTopDown(dp,n,k);
    }

    static int waysBottomUp(int n, int k){
        int dp[][]=new int[n+1][k+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k && j<=i;j++){
                dp[i][j]=dp[i-j][j]+dp[i-1][j-1];
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(waysRecursive(4,4));
        System.out.println(waysRecursive(5,4));
        System.out.println(waysRecursive(6,4));
        System.out.println(waysRecursive(7,4));
        System.out.println(waysRecursive(8,4));

        System.out.println();
        System.out.println(waysTopDown(4,4));
        System.out.println(waysTopDown(5,4));
        System.out.println(waysTopDown(6,4));
        System.out.println(waysTopDown(7,4));
        System.out.println(waysTopDown(8,4));

        System.out.println();
        System.out.println(waysBottomUp(4,4));
        System.out.println(waysBottomUp(5,4));
        System.out.println(waysBottomUp(6,4));
        System.out.println(waysBottomUp(7,4));
        System.out.println(waysBottomUp(8,4));
    }
}
