package coding.algo.recursion;

import java.util.Arrays;

/*
    https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
 */
public class PrintAllPathsInMatrix {
    void printAllPaths(int a[][], int m, int n){
        printAllPathsUtil(a, m, n, 0, 0, new int[m+n], 0);
    }

    void printAllPathsUtil(int a[][], int m, int n, int i, int j, int paths[], int pi){
        if(i>=m || j>=n)  return;
        paths[pi]=a[i][j];
        if (i==m-1 && j==n-1){
            System.out.println(Arrays.toString(paths));
            return;
        }
        printAllPathsUtil(a, m, n, i+1, j, paths, pi+1);
        printAllPathsUtil(a, m, n, i, j+1, paths, pi+1);
    }

    public static void main(String[] args) {
        int a[][]=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new PrintAllPathsInMatrix().printAllPaths(a, 3, 3);
    }
}
