package coding.algo.dp;

public class Knapsack01 {

    static int getMaxValue(int capacity, int wt[], int val[], int i, int n){
        if(i==n || capacity==0){
            return 0;
        }
        if(wt[i]>capacity){
            return getMaxValue(capacity,wt,val,i+1,n);
        }
        return Math.max(val[i]+getMaxValue(capacity-wt[i],wt,val,i+1,n), getMaxValue(capacity, wt, val, i+1, n));
    }

    static int getMaxValueDp(int capacity, int wt[], int val[]){
        int dp[][]=new int[wt.length+1][capacity+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i==0)    dp[i][j]=0;
                else if(j<wt[i-1])   dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
            }
        }
        return dp[wt.length][capacity];
    }

    public static void main(String[] args) {
        int wt[]=new int[]{10,20,30};
        int val[]=new int[]{60,100,120};

        System.out.println(getMaxValue(40,wt,val,0,wt.length));
        System.out.println(getMaxValueDp(45,wt,val));
    }
}
