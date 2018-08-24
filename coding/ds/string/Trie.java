package coding.ds.string;

import lombok.ToString;

import java.util.*;

public class Trie {
    @ToString
    static class Node{
        Map<Character,Node> child;
        boolean isWord;

        Node(){
            child=new HashMap<>(26);
            isWord=false;
        }
    }

    Node root;

    Trie(){
        root=new Node();
    }

    @Override
    public String toString() {
        return root.toString();
    }

    void insert(String s){
        Node p=root;
        for (int i = 0; i < s.length(); i++) {
            Node q=p.child.get(s.charAt(i));
            if(q==null){
                q=new Node();
                p.child.put(s.charAt(i),q);
            }
            if(i==s.length()-1){
                q.isWord=true;
            }
            p=q;
        }
    }

    boolean search(String s){
        Node p=root;
        for (int i = 0; i < s.length(); i++) {
            Node q=p.child.get(s.charAt(i));
            if(q==null) return false;
            if(i==s.length()-1 && q.isWord) return true;
            p=q;
        }
        return false;
    }

    List<String> suggest(String s){
        return complete(s);
    }

    List<String> complete(String s){
        List<String> res=new ArrayList<>();
        Node p=root;
        StringBuilder sb=new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
            Node q=p.child.get(s.charAt(i));
            if(q!=null){
                sb.insert(j++,s.charAt(i));
                if(i==s.length()-1){
                    return dfs(q,res,sb,j);
                }
                p=q;
            }
            else
                break;
        }
        return res;
    }

    List<String> dfs(Node q, List<String> res, StringBuilder sb, int j){
        if(q.isWord)    res.add(sb.toString());
        for(Map.Entry<Character,Node> e : q.child.entrySet()){
            sb.insert(j,e.getKey());
            dfs(e.getValue(),res,sb,j+1);
            sb.delete(j,sb.length());
        }
        return res;
    }

    public static void main(String[] args) {
        Trie t=new Trie();
        t.insert("somnath");
        t.insert("somu");
        t.insert("soumen");
        t.insert("koshik");
        t.insert("kebala");
        t.insert("koi");
        t.insert("amar");
        t.insert("aman");
        t.insert("aar");
        t.insert("biju");
        t.insert("bak");
        System.out.println(t.toString());
        System.out.println(t.search("abcd"));
        System.out.println(t.search("abc"));
        while(true) {
            System.out.println(t.suggest(new Scanner(System.in).next()));
        }
    }
}
