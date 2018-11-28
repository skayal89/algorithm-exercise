package coding.algo.dp;

import coding.util.ArrayUtil;

public class PainterPartition {

    static int partition(int a[], int n, int k){
        int dp[][]=new int[k][n];
        for(int i=0;i<k;i++){
            dp[i][0]=a[0];
        }
        for(int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+a[i];
        }
        ArrayUtil.print(dp);
        System.out.println();
        for(int i=1;i<k;i++){
            for(int j=1;j<n;j++){
                int res=Integer.MAX_VALUE;
                for(int p=1;p<=j;p++){
                    int sub=Math.max(dp[i-1][p-1],sum(a,p,j));
                    res=Math.min(res,sub);
                }
                dp[i][j]=res;
                ArrayUtil.print(dp);
                System.out.println();
            }
        }
        return dp[k-1][n-1];
    }

    static int sum(int a[], int from, int to){
        int s=0;
        for(int i=from;i<=to;i++)
            s+=a[i];
        return s;
    }

    public static void main(String[] args) {
        int a[]=new int[]{10,20,30,40};
        System.out.println(partition(a,a.length,2));

        int b[]=new int[]{100,200,300,400,500,600,700,800,900};
        System.out.println(partition(b,b.length,3));
    }
}
