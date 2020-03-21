package coding.ds.string;

import coding.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a mapping between numbers and alphabets . Find the number of ways to decode a sequence of numbers
 * asked in LinkedIn
 *
 * eg: a - 21 b - 2 c - 54 d - 5 e -4 f-1
     2154
     1) ac
     2) ade
     3) bfc
     4) bfde
   4 ways to decode
 */
public class WaysToDecodeString {
    static int numberOfWays(String s, int n, Map<Integer,Character> map){
        if(n<=0)    return 0;
        if(n==1)    return 1;
        int count=0;
        for (int i=1;i<=n;i++){
            int x=Integer.parseInt(s.substring(0,i));
            if(map.containsKey(x)){
                String ns=s.substring(i);
                if(i==n)    count++; // if entire string is present in map
                else    count += numberOfWays(ns, ns.length(), map);
            }
        }
        return count;
    }

    static int numberOfWaysDP(String s, Map<Integer,Character> map){
        int n=s.length();
        int dp[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }

        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j=i+l-1;
                dp[i][j]=map.containsKey(Integer.parseInt(s.substring(i,j+1))) ? 1 : 0;
                for(int k=i+1;k<=j;k++){
                    int x=Integer.parseInt(s.substring(i,k));
                    if(map.containsKey(x)){
                        dp[i][j]+=dp[k][j];
                    }
                }
            }
        }
        ArrayUtil.print(dp);
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        Map<Integer,Character> map=new HashMap<>();
        map.put(21,'a');
        map.put(2,'b');
        map.put(54,'c');
        map.put(5,'d');
        map.put(4,'e');
        map.put(1,'f');
        String s="2154";
        System.out.println(numberOfWays(s,s.length(),map));
        System.out.println(numberOfWaysDP(s,map));
    }
}
