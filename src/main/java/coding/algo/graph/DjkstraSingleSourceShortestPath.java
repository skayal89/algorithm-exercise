package coding.algo.graph;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DjkstraSingleSourceShortestPath {

    @AllArgsConstructor
    static class Graph{
        int V;
        int adj[][];
    }

    @AllArgsConstructor
    @ToString
    static class Node{
        int vertex, dist;

        public Node(int vertex) {
            this.vertex = vertex;
        }

        @Override
        public boolean equals(Object obj) {
            return this.vertex==((Node)obj).vertex;
        }
    }

    void djkstra(Graph g, int source){
        // we should use minHeap with Map implementation
        PriorityQueue<Node> minHeap=new PriorityQueue<Node>((n1, n2)->n1.dist-n2.dist);
        minHeap.add(new Node(source,0));
        for (int i=0;i<g.V;i++){
            if(i!=source){
                minHeap.add(new Node(i, Integer.MAX_VALUE));
            }
        }
        int parent[]=new int[g.V];
        int distance[]=new int[g.V];

        Arrays.fill(parent,-1);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source]=0;

        while (!minHeap.isEmpty()){
            System.out.println(minHeap);
            Node temp=minHeap.poll();
            int u=temp.vertex;
            for (int v = 0; v < g.V; v++) {
                // If vertex is not present in heap, that means it has already been considered in shortestPathSet
                if(g.adj[u][v]!=0 && minHeap.contains(new Node(v)) && (distance[v]==Integer.MAX_VALUE || distance[v]>distance[u]+g.adj[u][v])){
                    distance[v]=distance[u]+g.adj[u][v];
                    // in place of decreaseKey operation
                    minHeap.remove(new Node(v));
                    minHeap.add(new Node(v, distance[v]));
                    parent[v]=u;
                }
            }
        }

        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        int adj[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Graph graph = new Graph(9, adj);
        DjkstraSingleSourceShortestPath d=new DjkstraSingleSourceShortestPath();
        d.djkstra(graph,0);
    }

}
