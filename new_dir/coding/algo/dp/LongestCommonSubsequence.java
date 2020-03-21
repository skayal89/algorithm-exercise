package coding.algo.dp;

public class LongestCommonSubsequence {

    static int lcs(String s1,String s2, int i, int j){
        if(i==s1.length() || j==s2.length())    return 0;
        if(s1.charAt(i)==s2.charAt(j))  {
            return 1+lcs(s1, s2, i+1, j+1);
        }
        return Math.max(lcs(s1, s2, i+1, j),lcs(s1, s2, i, j+1));
    }

    static int lcsDP(String s1, String s2){
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j]=s1.charAt(i-1)==s2.charAt(j-1) ? 1+dp[i-1][j-1] : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcdgh","aedfhr",0,0));
        System.out.println(lcs("aggtab","gxtxayb",0,0));
        System.out.println(lcsDP("abcdgh","aedfhr"));
        System.out.println(lcsDP("aggtab","gxtxayb"));
    }
}
