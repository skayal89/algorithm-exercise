package coding.algo.dp;


public class EditDistance {

    static int distanceRecurr(String s1, String s2, int i, int j){
        if(i==s1.length())  return s2.length()-j;
        if(j==s2.length())  return s1.length()-i;
        if(s1.charAt(i)==s2.charAt(j)){
            return distanceRecurr(s1,s2,i+1,j+1);
        }
        return 1+ Math.min(distanceRecurr(s1, s2, i, j+1),Math.min(distanceRecurr(s1, s2, i+1, j), distanceRecurr(s1, s2, i+1, j+1)));
    }

    static int distanceDP(String s1, String s2, int m,int n){
        int dp[][]=new int[m+1][n+1];
        for (int i = 0; i < n+1; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j]=s1.charAt(i-1)==s2.charAt(j-1) ? dp[i-1][j-1] : 1+min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
            }
        }
        return dp[m][n];
    }

    static int min(int a, int b, int c){
        return a<b ? (a<c ? a : c) : (b<c ? b : c);
    }

    public static void main(String[] args) {
        System.out.println(distanceRecurr("geeks","gfekij",0,0));
        String s="ghks";
        String t="geekst";
        System.out.println(distanceDP(s,t,s.length(),t.length()));
        System.out.println(min(30,6,10));
    }
}
