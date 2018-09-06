package coding.algo.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponent {

    private static int time=1;

    static class Graph{
        int V;
        List<Integer> adj[];

        public Graph(int v) {
            V = v;
            adj=new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i]=new LinkedList<>();
            }
        }

        void addEdge(int u, int v){
            // Directed graph. Edge from u to v
            adj[u].add(v);
        }
    }

    void dfs(Graph g){
        boolean visited[]=new boolean[g.V];
        boolean stackMember[]=new boolean[g.V];
        Stack<Integer> s=new Stack<>();
        int low[]=new int[g.V];
        int disc[]=new int[g.V];
        for (int i = 0; i < g.V; i++) {
            if(!visited[i]){
                dfsUtil(g, i, visited, low, disc, s, stackMember);
            }
        }
    }

    void dfsUtil(Graph g, int u, boolean visited[], int low[], int disc[], Stack<Integer> s, boolean stackMember[]){
        visited[u]=stackMember[u]=true;
        low[u]=disc[u]=time++;
        s.push(u);

        List<Integer> adjacent=g.adj[u];
        for (Integer v : adjacent){
            if(!visited[v]){
                dfsUtil(g, v, visited, low, disc, s, stackMember);
                // done exploring the child v, so low[v] must be contained the disc value of top most ancestor
                low[u]=Math.min(low[u],low[v]); // tree edge
            }
            else { // back edge or cross edge found from u to v, as v is already visited
                if(stackMember[v]) { // if v is in stack then it's back edge, otherwise it's a cross edge
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }

        // print a strongly connected component
        if(low[u]==disc[u]) {
            while (!s.empty() && s.peek()!=u) {
                int x = s.pop();
                stackMember[x] = false;
                System.out.print(x + " ");
            }
            if (!s.empty()) {
                int x = s.pop();
                stackMember[x] = false;
                System.out.print(x + "\n ");
            }
        }
    }

    public static void main(String[] args) {
        StronglyConnectedComponent component=new StronglyConnectedComponent();
        System.out.println("nSCCs in first graph n");
        Graph g1=new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        component.dfs(g1);

        System.out.println("nSCCs in second graph n");
        Graph g2=new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        component.dfs(g2);

        System.out.println("nSCCs in third graph n");
        Graph g3=new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        component.dfs(g3);

        System.out.println("nSCCs in fourth graph n");
        Graph g4=new Graph(11);
        g4.addEdge(0,1);g4.addEdge(0,3);
        g4.addEdge(1,2);g4.addEdge(1,4);
        g4.addEdge(2,0);g4.addEdge(2,6);
        g4.addEdge(3,2);
        g4.addEdge(4,5);g4.addEdge(4,6);
        g4.addEdge(5,6);g4.addEdge(5,7);g4.addEdge(5,8);g4.addEdge(5,9);
        g4.addEdge(6,4);
        g4.addEdge(7,9);
        g4.addEdge(8,9);
        g4.addEdge(9,8);
        component.dfs(g4);

        System.out.println("nSCCs in fifth graph n");
        Graph g5=new Graph(5);
        g5.addEdge(0,1);
        g5.addEdge(1,2);
        g5.addEdge(2,3);
        g5.addEdge(2,4);
        g5.addEdge(3,0);
        g5.addEdge(4,2);
        component.dfs(g5);
    }
}
