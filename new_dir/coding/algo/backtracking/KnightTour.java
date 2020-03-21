package coding.algo.backtracking;

import coding.util.ArrayUtil;

import java.util.Arrays;

public class KnightTour {
    void tour(){
        int moveX[]=new int[]{2, 1, -1, -2, -2, -1, 1, 2}; // anti-clockwise movement
        int moveY[]=new int[]{1, 2, 2, 1, -1, -2, -2, -1}; // any other movement doesn't lead to a sol, not sure why??
        int[][] sol=new int[8][8];
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                sol[i][j]=-1;
            }
        }
        sol[0][0]=0;
        util(0,0,8,moveX,moveY,sol,1);
        ArrayUtil.print(sol);
    }

    boolean util(int i, int j, int n, int moveX[], int moveY[], int[][] sol, int move){
        if(move==n*n)   return true;
        for (int k = 0; k < 8; k++) {
            int x=i+moveX[k];
            int y=j+moveY[k];
            if(isValid(x,y,n, sol)) {
                sol[x][y]=move;
                //ArrayUtil.print(sol);
                if (util(x, y, n, moveX, moveY, sol, move + 1)){
                    System.out.println(x+","+y+" -> "+sol[x][y]);
                    return true; // found a solution, so break the loop. no need to check another moves.
                }
                else sol[x][y]=-1; // this move doesn't lead to a solution
            }
        }
        return false;
    }

    boolean isValid(int i, int j, int n, int sol[][]){
        return (i>=0 && j>=0 && i<n && j<n && sol[i][j]==-1);
    }

    public static void main(String[] args) {
        new KnightTour().tour();
    }
}
