package coding.algo.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    Map<Integer, Node> map=new HashMap<>();

    static class Node{
        int data;
        Node parent;
        int rank;

        @Override
        public boolean equals(Object obj) {
            return ((Node) obj).data==this.data;
        }
    }

    void makeSet(int i){
        Node t=new Node();
        t.data=i;
        t.parent=t;
        t.rank=0;
        map.put(i,t);
    }

    int find(int i){
        return map.get(i).data;
    }

    Node find(Node t){
        Node p=t.parent;
        if(p == t)    return t;
        t.parent=find(p);
        return t.parent;
    }

    void union(int i, int j){
        Node pi=find(map.get(i));
        Node pj=find(map.get(j));

        if(pi==pj)  return;
        if(pi.rank==pj.rank){
            pj.parent=pi;
            pi.rank++;
        }
        if(pi.rank>pj.rank){
            pj.parent=pi;
        }
        else {
            pi.parent=pj;
        }
    }


}
