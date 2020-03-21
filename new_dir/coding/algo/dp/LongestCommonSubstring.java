package coding.algo.dp;

public class LongestCommonSubstring {

    static int lcs(String s1,String s2, int m, int n){
        int dp[][]=new int[m+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i]=0;
        }

        int max=-1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j]=s1.charAt(i-1)==s2.charAt(j-1) ? dp[i-1][j-1]+1 : 0;
                if(max<dp[i][j])    max=dp[i][j];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        String s1="abcdaf";
        String s2="zbcdf";
        System.out.println(lcs(s1,s2,s1.length(),s2.length()));
    }
}
