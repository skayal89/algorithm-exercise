package coding.ds.array;

import java.util.Arrays;

public class KthLargestMinHeap {

    static class MinHeap{
        int[] h;
        int capacity;
        int size;

        MinHeap(int capacity){
            this.capacity=capacity;
            this.size=0;
            h=new int[capacity];
        }

        void insert(int element){
            if(capacity==size)
            {
                if(element>h[0]) {
                    h[0] = element;
                    buildHeap(0);
                }
                return;
            }
            int i=size;
            h[size++]=element;
            while (h[i]<h[parent(i)]){
                int t=h[i];
                h[i]=h[parent(i)];
                h[parent(i)]=t;
                i=parent(i);
            }
        }

        void buildHeap(int i){
            if(!isValid(i)) return;
            int l=left(i);
            int r=right(i);
            int smallest=i;
            if(isValid(l) && h[smallest]>h[l]){
                smallest=l;
            }
            if(isValid(r) && h[smallest]>h[r]){
                smallest=r;
            }
            if(smallest!=i){
                int t=h[i];
                h[i]=h[smallest];
                h[smallest]=t;
                buildHeap(smallest);
            }
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

        int peek(){
            if(size==0) return Integer.MIN_VALUE;
            return h[0];
        }

        void print(){
            System.out.println(Arrays.toString(h));
        }
    }

    int kLargest(int a[], int k){
        MinHeap heap=new MinHeap(k);
        for(int i=0;i<a.length;i++){
            heap.insert(a[i]);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int a[]=new int[]{3,7,4,1,9,5};
        System.out.println(new KthLargestMinHeap().kLargest(a,4));
    }
}
