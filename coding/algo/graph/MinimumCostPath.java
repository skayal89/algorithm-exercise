package coding.algo.graph;

import coding.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/minimum-cost-path-left-right-bottom-moves-allowed/
public class MinimumCostPath {
    @AllArgsConstructor
    static class Graph{
        int V;
        int adj[][];
    }

    @AllArgsConstructor
    @ToString
    static class Node{
        int row, col, dist;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            return this.row==((Node)obj).row && this.col==((Node)obj).col;
        }
    }

    int djkstra(int adj[][], int m, int n, int moveX[], int moveY[]){
        // we should use minHeap with Map implementation
        PriorityQueue<Node> minHeap=new PriorityQueue<Node>((n1, n2)->n1.dist-n2.dist);

        for (int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                minHeap.add(new Node(i, j, Integer.MAX_VALUE));
            }

        }
        minHeap.remove(new Node(0,0));
        minHeap.add(new Node(0,0, adj[0][0]));

        int distance[][]=new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[0][0]=adj[0][0];

        while (!minHeap.isEmpty()){
            System.out.println(minHeap);
            Node u=minHeap.poll();

            for (int v = 0; v < 4; v++) {
                int x=u.row+moveX[v];
                int y=u.col+moveY[v];
                // If vertex is not present in heap, that means it has already been considered in shortestPathSet
                if(isValidMove(x, y, m, n) && minHeap.contains(new Node(x,y)) && (distance[x][y]==Integer.MAX_VALUE || distance[x][y]>distance[u.row][u.col]+adj[x][y])){
                    distance[x][y]=distance[u.row][u.col]+adj[x][y];
                    // in place of decreaseKey operation
                    minHeap.remove(new Node(x,y));
                    minHeap.add(new Node(x,y, distance[x][y]));
                }
            }
        }

        ArrayUtil.print(distance);

        return distance[m-1][n-1];
    }

    private boolean isValidMove(int x, int y, int row, int col) {
        return x>=0 && x<col && y>=0 && y<row;
    }

    int minCost(int cost[][], int m, int n){
        int moveX[]=new int[]{0,0,-1,1};
        int moveY[]=new int[]{-1,1,0,0};

        return djkstra(cost, m, n, moveX, moveY);
    }

    public static void main(String[] args) {
        int grid[][] =new int[][]
        {
                {31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}
        };
        System.out.println(new MinimumCostPath().minCost(grid,5,5));
    }
}
