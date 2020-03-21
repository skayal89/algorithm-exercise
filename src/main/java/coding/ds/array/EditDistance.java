package coding.ds.array;

public class EditDistance {
    public static void main(String[] args) {
        String s="abcdf",t="abf";
        //System.out.println(t.length());
        System.out.println(distanceUsingDP(s,t,s.length(),t.length()));
    }

    public static int distance(String s, String t, int m, int n){
        if(m==0 && n==0)  return 0;
        if(m==0)  return n;
        if(n==0)    return m;
        if(s.charAt(m-1)==t.charAt(n-1)){
            return distance(s,t,m-1,n-1);
        }
        return 1+Math.min(distance(s,t,m-1,n-1),Math.min(distance(s,t,m,n-1),distance(s,t,m-1,n)));
    }

    public static int distanceUsingDP(String s, String t, int m, int n){
        int dp[][]=new int[m+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j]=s.charAt(i-1)==t.charAt(j-1) ? dp[i-1][j-1] : 1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
            }
        }
        return dp[m][n];
    }
}
