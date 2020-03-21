package coding.algo.dp;

import coding.util.ArrayUtil;

import java.util.Arrays;

public class PalindromeTable {

    static boolean[][] buildPalindromeTable(String s){
        int n=s.length();
        boolean dp[][]=new boolean[n][n];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j=i+l-1;
                if(i==j)    dp[i][j]=true;
                else if(s.charAt(i)==s.charAt(j) && l==2) dp[i][j]=true;
                else if(s.charAt(i)==s.charAt(j) && l>2){
                    dp[i][j]=dp[i+1][j-1];
                }
            }
        }
        return dp;
    }

    static boolean isPalindrome(String s, int from, int to){
        boolean dp[][]=buildPalindromeTable(s);
        ArrayUtil.print(dp);
        return dp[from][to];
    }

    public static void main(String[] args) {
        String s="baabcbc"; // aa is a corner case (l==2)
        System.out.println(isPalindrome(s,4,6));
    }
}
