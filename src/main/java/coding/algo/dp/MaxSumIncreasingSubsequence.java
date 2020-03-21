package coding.algo.dp;

public class MaxSumIncreasingSubsequence {
    int getMaxSum(int a[], int n){
        int dp[]=new int[n];
        int parent[]=new int[n];

        for (int i = 0; i < n; i++) {
            dp[i]=a[i];
            parent[i]=-1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j]<a[i]){
                    if(dp[i]<dp[j]+a[i]){
                        dp[i]=dp[j]+a[i];
                        parent[i]=j;
                    }
                }
            }
        }

        int maxSum=Integer.MIN_VALUE, maxIndex=-1;
        for (int i=0;i<n;i++){
            if(maxSum<dp[i]){
                maxSum=dp[i]; // get the max sum
                maxIndex=i;
            }
        }
        int j=maxIndex;
        while (j>=0){ // print the sub-sequence
            System.out.print(a[j]+" ");
            j=parent[j];
        }
        System.out.println();
        return maxSum;
    }

    public static void main(String[] args) {
        int a[]=new int[]{1, 101, 2, 3, 100, 4, 5};
        System.out.println("Sum: "+new MaxSumIncreasingSubsequence().getMaxSum(a,a.length));
    }
}
