package coding.ds.array;

import coding.ds.string.Trie;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class KMostFreqWords {

    @AllArgsConstructor
    static class HeapNode{
        TrieNode lastNode;
        int freq;
        String word;

        @Override
        public String toString() {
            return "HeapNode{" +
                    "lastNode=" + lastNode +
                    ", freq=" + freq +
                    ", word='" + word + '\'' +
                    '}';
        }
    }

    static class MinHeap{
        HeapNode[] h;
        int capacity;
        int size;
        Comparator<HeapNode> comparator;

        MinHeap(int capacity, Comparator<HeapNode> comparator){
            this.capacity=capacity;
            this.size=0;
            h=new HeapNode[capacity];
            this.comparator=comparator;
        }

        void insert(HeapNode element){
            if(capacity==size)
            {
                if(element.freq>h[0].freq) {
                    h[0].lastNode.heapIndex=-1;
                    h[0] = element;
                    h[0].lastNode.heapIndex=0;
                    buildHeap(0);
                }
                return;
            }
            int i=size;
            h[size++]=element;
            h[i].lastNode.heapIndex=i;
            while (h[i].freq<h[parent(i)].freq){
                HeapNode t=h[i];
                h[i]=h[parent(i)];
                h[parent(i)]=t;
                h[parent(i)].lastNode.heapIndex=parent(i);
                i=parent(i);
            }
        }

        void buildHeap(int i){
            if(!isValid(i)) return;
            int l=left(i);
            int r=right(i);
            int smallest=i;
            if(isValid(l) && h[smallest].freq>h[l].freq){
                smallest=l;
            }
            if(isValid(r) && h[smallest].freq>h[r].freq){
                smallest=r;
            }
            if(smallest!=i){
                HeapNode t=h[i];
                h[i]=h[smallest];
                h[smallest]=t;
                h[smallest].lastNode.heapIndex=smallest;
                buildHeap(smallest);
            }
        }

        void increaseFreq(int index){
            System.out.println("Increasing freq of "+index);
            h[index].freq++;
            buildHeap(index);

        }

        int parent(int i){
            return (i-1)/2;
        }

        int left(int i){
            return 2*i+1;
        }

        int right(int i){
            return 2*i+2;
        }

        boolean isValid(int i){
            return i>=0 && i<size;
        }

        HeapNode peek(){
            if(size==0) return null;
            return h[0];
        }

        void print(){
            System.out.println(Arrays.toString(h));
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isWord;
        int freq;
        int heapIndex;

        TrieNode(){
            child=new HashMap<>();
            isWord=false;
            freq=0;
            heapIndex=-1;
        }

        TrieNode root;
        MinHeap minHeap;
        TrieNode(int k){
            this.root=new TrieNode();
            minHeap=new MinHeap(k, new Comparator<HeapNode>() {
                @Override
                public int compare(HeapNode o1, HeapNode o2) {
                    return o1.freq-o2.freq;
                }
            });
        }


        void insert(String s){
            TrieNode temp=root;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                TrieNode t=temp.child.get(c);
                if(t==null){
                    t=new TrieNode();
                    temp.child.put(c,t);
                }
                if(i==s.length()-1){
                    if(!t.isWord) {
                        t.isWord = true;
                        t.freq = 1;
                        minHeap.insert(new HeapNode(t, 1, s));
                        /*
                        max size of heap is k. If we already have inserted k elements then root will be replaced
                        by new element iff the freq of new element is higher. If the freq is same we will ignore
                        the element but will be inserted in Trie with updated freq.
                         */
                    }
                    else{
                        t.freq++; // t.heapIndex can be -1 in case of the same freq and we could have ignored this element
                        if(minHeap.isValid(t.heapIndex)) {
                            minHeap.increaseFreq(t.heapIndex);
                        }
                        else { // we have ignored this element until the freq was less than the root of heap. When freq become greater, we need replace the root
                            minHeap.insert(new HeapNode(t, t.freq, s));
                        }
                    }
                }
                temp=t;
            }
        }

        HeapNode getKthMostFreqString(){
            return minHeap.peek();
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "child=" + child +
                    ", isWord=" + isWord +
                    ", freq=" + freq +
                    ", heapIndex=" + heapIndex +
                    ", root=" + root +
                    ", minHeap=" + minHeap +
                    '}';
        }

        void printHeap(){
            minHeap.print();
            System.out.println(root);
        }
    }

    String kMostFreq(String s[], int k){
        TrieNode trieNode=new TrieNode(k);
        for(int i=0;i<s.length;i++){
            System.out.println("Inserting "+s[i]);
            trieNode.insert(s[i]);
            trieNode.printHeap();
        }
        return trieNode.getKthMostFreqString().word;
    }

    public static void main(String[] args) {
        KMostFreqWords mostFreqWords = new KMostFreqWords();
        String s[]=new String[]{"abc","hi","abc","xyz","xyz","abc"};
        System.out.println(mostFreqWords.kMostFreq(s,3));
    }
}
