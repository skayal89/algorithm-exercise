package coding.algo.backtracking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

public class NQueee {
    @Data
    @AllArgsConstructor
    private static class Position{
        int row,col;
    }

    public void nqueen(int n){
        /*
         * position[i] is the position of ith queen
         */
        Position position[]=new Position[n];
        if(nQueenUtil(position,n,0)){
            Arrays.stream(position).forEach(System.out::println);
        }
        else {
            System.out.println("Can't be placed");
        }
    }

    private boolean nQueenUtil(Position p[], int n, int queen){
        if(queen==n)    return true;
        for (int i=0;i<n;i++){
            if(isSafe(p, queen, i)){
                p[queen]=new Position(queen,i);
                if(nQueenUtil(p, n, queen+1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSafe(Position[] p, int q, int i){
        for (int j = 0; j < q; j++) {
            if(i==p[j].col || q+i==p[j].row+p[j].col || q-i==p[j].row-p[j].col){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueee nQueee=new NQueee();
        nQueee.nqueen(4);
    }
}
