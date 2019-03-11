package coding.algo.dp;

import coding.util.ArrayUtil;

/*
 * https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
 *
 * Amazon, Microsoft, LinkedIn
 */
public class BooleanParenthesization {
    public static int countWaysOfParenthesization(char[] symbols, char[] operators){
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
            System.out.println();
            ArrayUtil.print(T);
            System.out.println();
            ArrayUtil.print(F);
        }

        return T[0][n-1];
    }

    public static void main(String[] args) {
        char symb[]=new char[]{'T','T','F','T'};
        char op[]=new char[]{'|','&','^'};

        System.out.println(countWaysOfParenthesization(symb,op));
    }
}
