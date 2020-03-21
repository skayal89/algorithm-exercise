package coding.algo.dp;

import java.util.concurrent.TimeUnit;

public class CatalanNumber {

    // C(n+1) = sum of all values{ C(i)*C(n-i), for i=0 to n-1 }
    public static long catalanRecursive(int n){
        if(n<=1)    return 1;
        long result=0;
        for(int i=0;i<n;i++){
            result+=catalanRecursive(i)*catalanRecursive(n-i-1);
        }
        return result;
    }

    public static long catalanDP(int n){
        long[] dp=new long[n+1];
        dp[0]=dp[1]=1;
        for (int i = 2; i <= n; i++) {
            long temp=0;
            for (int j = 0; j < i; j++) {
                temp+=dp[j]*dp[i-j-1];
            }
            dp[i]=temp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("DP");
        long s1=System.nanoTime();
        System.out.println(catalanDP(60));
        System.out.println("Time:"+TimeUnit.SECONDS.convert((System.nanoTime()-s1), TimeUnit.NANOSECONDS));

        System.out.println("Recursive");
        long s2=System.nanoTime();
        System.out.println(catalanRecursive(21));
        System.out.println("Time:"+TimeUnit.SECONDS.convert((System.nanoTime()-s2), TimeUnit.NANOSECONDS));
    }
}
