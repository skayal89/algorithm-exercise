package coding.algo.dp;

import coding.util.ArrayUtil;

/*
 * https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
 *
 * Amazon, Microsoft, LinkedIn
 */
public class BooleanParenthesization {

    public static int countWaysOfParenthesizationRecursion(char[] symbols, char[] operators){
        return countWaysOfParenthesizationRecursion(symbols, operators,0,symbols.length-1,true);
    }

    public static int countWaysOfParenthesizationRecursion(char[] symbols, char[] operators, int low, int high, boolean isTrue){
        if(low > high)    return 0;
        if(low==high){
            if(isTrue){
                return symbols[low]=='T' ? 1 : 0;
            }
            else{
                return symbols[low]=='F' ? 1 : 0;
            }
        }

        int countWays = 0;
        for (int k = low; k < high; k++) {
            int leftTrue = countWaysOfParenthesizationRecursion(symbols, operators,low,k,true);
            int leftFalse = countWaysOfParenthesizationRecursion(symbols, operators,low,k,false);
            int rightTrue = countWaysOfParenthesizationRecursion(symbols, operators,k+1,high,true);
            int rightFalse = countWaysOfParenthesizationRecursion(symbols, operators,k+1,high,false);

            int total_ik = leftTrue + leftFalse;
            int total_kj = rightTrue + rightFalse;

            if(operators[k]=='&'){
                if(isTrue)
                    countWays += leftTrue * rightTrue;
                else
                    countWays += (total_ik*total_kj - leftTrue * rightTrue);
            }
            else if(operators[k]=='|'){
                if(isTrue)
                    countWays += (total_ik*total_kj - leftFalse*rightFalse);
                else
                    countWays += leftFalse*rightFalse;
            }
            else if(operators[k]=='^'){
                if(isTrue)
                    countWays += leftTrue*rightFalse + leftFalse*rightTrue;
                else
                    countWays += leftTrue*rightTrue + leftFalse*rightFalse;
            }
        }
        return countWays;
    }

    public static int countWaysOfParenthesizationTopDownDP(char[] symbols, char[] operators){
        int n = symbols.length;
        int dp[][][] = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k<2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return countWaysOfParenthesizationTopDownDP(symbols, operators,dp,0,n-1,1);
    }

    public static int countWaysOfParenthesizationTopDownDP(char[] symbols, char[] operators, int dp[][][], int low, int high, int isTrue){
        if(low > high)    return 0;
        if(low==high){
            if(isTrue == 1){
                return symbols[low]=='T' ? 1 : 0;
            }
            else{
                return symbols[low]=='F' ? 1 : 0;
            }
        }

        if(dp[low][high][isTrue]!=-1)   return dp[low][high][isTrue];

        int countWays = 0;
        for (int k = low; k < high; k++) {
            int leftTrue = countWaysOfParenthesizationRecursion(symbols, operators,low,k,true);
            int leftFalse = countWaysOfParenthesizationRecursion(symbols, operators,low,k,false);
            int rightTrue = countWaysOfParenthesizationRecursion(symbols, operators,k+1,high,true);
            int rightFalse = countWaysOfParenthesizationRecursion(symbols, operators,k+1,high,false);

            int total_ik = leftTrue + leftFalse;
            int total_kj = rightTrue + rightFalse;

            if(operators[k]=='&'){
                if(isTrue == 1)
                    countWays += leftTrue * rightTrue;
                else
                    countWays += (total_ik*total_kj - leftTrue * rightTrue);
            }
            else if(operators[k]=='|'){
                if(isTrue == 1)
                    countWays += (total_ik*total_kj - leftFalse*rightFalse);
                else
                    countWays += leftFalse*rightFalse;
            }
            else if(operators[k]=='^'){
                if(isTrue == 1)
                    countWays += leftTrue*rightFalse + leftFalse*rightTrue;
                else
                    countWays += leftTrue*rightTrue + leftFalse*rightFalse;
            }
        }
        return (dp[low][high][isTrue] = countWays);
    }

    public static int countWaysOfParenthesizationBottomUpDP(char[] symbols, char[] operators){
        int n=symbols.length;

        int[][] T=new int[n][n];
        int[][] F=new int[n][n];

        for(int i=0;i<n;i++){
            T[i][i]=symbols[i]=='T' ? 1 : 0;
            F[i][i]=symbols[i]=='F' ? 1 : 0;
        }

        for(int l=2;l<=n;l++){
            for (int i=0;i<n-l+1;i++){
                int j=i+l-1;
                T[i][j] = F[i][j] = 0;
                for(int k=i;k<j;k++){
                    int total_ik = T[i][k]+F[i][k];
                    int total_kj = T[k+1][j]+F[k+1][j];

                    if(operators[k]=='&'){
                        T[i][j] += T[i][k]*T[k+1][j];
                        F[i][j] += (total_ik*total_kj - T[i][k]*T[k+1][j]);
                    }
                    else if(operators[k]=='|'){
                        T[i][j] += (total_ik*total_kj - F[i][k]*F[k+1][j]);
                        F[i][j] += F[i][k]*F[k+1][j];
                    }
                    else if(operators[k]=='^'){
                        T[i][j] += T[i][k]*F[k+1][j] + F[i][k]*T[k+1][j];
                        F[i][j] += T[i][k]*T[k+1][j] + F[i][k]*F[k+1][j];
                    }
                }
            }
//            System.out.println();
//            ArrayUtil.print(T);
//            System.out.println();
//            ArrayUtil.print(F);
        }

        return T[0][n-1];
    }

    public static void main(String[] args) {
        char symb[]=new char[]{'T','T','F','T'};
        char op[]=new char[]{'|','&','^'};

        System.out.println(countWaysOfParenthesizationRecursion(symb,op));
        System.out.println(countWaysOfParenthesizationTopDownDP(symb,op));
        System.out.println(countWaysOfParenthesizationBottomUpDP(symb,op));
    }
}
