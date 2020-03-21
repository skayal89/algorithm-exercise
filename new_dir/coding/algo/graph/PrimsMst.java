package coding.algo.graph;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimsMst {

    @AllArgsConstructor
    static class Graph{
        int V;
        int adj[][];
    }

    @AllArgsConstructor
    @ToString
    static class Node{
        int vertex, distance; // distance ( or wight of the edge from u to v)

        public Node(int vertex) {
            this.vertex = vertex;
        }

        @Override
        public boolean equals(Object obj) {
            return this.vertex==((Node)obj).vertex;
        }
    }

    static void buildMST(Graph g){
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(g.V, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.distance -o2.distance;
            }
        });

        minHeap.add(new Node(0,0));
        for (int i = 1; i < g.V; i++) {
            minHeap.add(new Node(i, Integer.MAX_VALUE));
        }
        int distance[]=new int[g.V];
        int parent[]=new int[g.V];

        Arrays.fill(parent,-1);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0]=0;

        while (!minHeap.isEmpty()){ // this loop will run exactly V-1 times
            Node t=minHeap.poll();
            int u=t.vertex;
            for(int v=0;v<g.V;v++){ // traverse all adjacent vertex of u
                if(g.adj[u][v]!=0 && minHeap.contains(new Node(v)) && distance[v]>g.adj[u][v]){
                    distance[v]=g.adj[u][v];
                    // in place of decreaseKey operation
                    minHeap.remove(new Node(v));
                    minHeap.add(new Node(v, distance[v]));
                    parent[v]=u;
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(distance));
        System.out.println();
        printMST(parent, distance, g.V);
    }

    static void printMST(int parent[], int[] distance, int V)
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) // vertex-0 should not be printed because it's starting vertex
            System.out.println(parent[i]+" - "+ i+"\t"+
                    distance[i]);
    }

    public static void main (String[] args)
    {
        /* Let us create the following graph
            2     3
        (0)---(1)---(2)
        |     / \   |
       6|   8/   \5 |7
        |   /     \ |
        (3)-------(4)
              9
        */

        int graph[][] = new int[][] {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        // Print the solution
        buildMST(new Graph(5, graph));
    }
}
