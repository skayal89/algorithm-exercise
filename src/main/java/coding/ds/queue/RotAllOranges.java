package coding.ds.queue;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
 * https://youtu.be/sxs1KdM5LZU
 */
public class RotAllOranges {

    @AllArgsConstructor
    class Cell{
        int x, y;

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Cell){
                Cell c = (Cell) obj;
                return this.x==c.x && this.y==c.y;
            }
            return false;
        }
    }

    int rotOranges(int a[][], int m, int n){
        Queue<Cell> queue=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j]==2){
                    queue.add(new Cell(i,j));
                }
            }
        }

        int time=0;
        boolean flag=false;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                Cell temp=queue.poll();
                if(isValid(a,temp.x+1, temp.y, m, n)){
                    a[temp.x+1][temp.y]=2;
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    queue.add(new Cell(temp.x+1, temp.y));
                }
                if(isValid(a,temp.x, temp.y+1, m, n)){
                    a[temp.x][temp.y+1]=2;
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    queue.add(new Cell(temp.x, temp.y+1));
                }
                if(isValid(a,temp.x-1, temp.y, m, n)){
                    a[temp.x-1][temp.y]=2;
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    queue.add(new Cell(temp.x-1, temp.y));
                }
                if(isValid(a,temp.x, temp.y-1, m, n)){
                    a[temp.x][temp.y-1]=2;
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    queue.add(new Cell(temp.x, temp.y-1));
                }
            }
            flag=false;
        }

        return hasAllRotten(a, m, n) ? time : -1;
    }

    boolean hasAllRotten(int a[][], int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(int a[][], int i, int j, int m, int n){
        return i>=0 && i<m && j>=0 && j<n && a[i][j]==1;
    }


    public static void main(String[] args)
    {
        int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};
        int ans = new RotAllOranges().rotOranges(arr,3,5);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }
}
