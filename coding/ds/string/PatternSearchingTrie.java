package coding.ds.string;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/
 * search all occurrences of the pattern
 */
public class PatternSearchingTrie {

    @ToString
    static class TrieNode{
        Map<Character,TrieNode> child;
        List<Integer> indexes;

        TrieNode(){
            child=new HashMap<>(26);
            indexes = new ArrayList<>();
        }
    }

    TrieNode root;

    void insert(String s, int index){
        TrieNode p=root;
        for (int i = 0; i < s.length(); i++) {
            TrieNode q=p.child.get(s.charAt(i));
            if(q==null){
                q=new TrieNode();
                p.child.put(s.charAt(i),q);
            }
            q.indexes.add(index+i);
            p=q;
        }
    }

    List<Integer> searchAllOccurrences(String pattern){
        TrieNode p=root;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<pattern.length();i++){
            TrieNode q=p.child.get(pattern.charAt(i));
            if(q==null) return null;
            int n=pattern.length()-1;
            if(i==n){
                System.out.println(q.indexes);
                for (Integer index : q.indexes){
                    result.add(index-n);
                }
                return result;
            }
            p=q;
        }
        return result;
    }

    List<Integer> search(String text, String pattern){
        root=new TrieNode();
        for(int i=0;i<text.length();i++){
            insert(text.substring(i),i);
        }
        System.out.println(root.toString());
        return searchAllOccurrences(pattern);
    }

    public static void main(String[] args) {
        PatternSearchingTrie pat=new PatternSearchingTrie();
        System.out.println(pat.search("ababa","abab"));
    }
}
