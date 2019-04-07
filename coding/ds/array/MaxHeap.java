package coding.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxHeap {
    int a[];
    int size,capacity;
    Map<Integer, Integer> map;

    MaxHeap(int capacity){
        this.size=0;
        this.a=new int[capacity];
        map=new HashMap<>(capacity);
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

    void buildHeap(int i){
        int l=left(i);
        int r=right(i);
        int largest=i;

        if(a[largest]<a[l]) largest=l;
        if(a[largest]<a[r]) largest=r;

        if(largest!=i){
            int t=a[largest];
            a[largest]=a[i];
            a[i]=t;
            map.put(a[i],i);
            map.put(a[largest],largest);
            buildHeap(largest);
        }
    }

    void add(int value){
        if(size==capacity)  return;
        a[size]=value;
        map.put(value,size);
        int i=size;
        size++;
        while (i>0 && a[parent(i)]<a[i]){
            int t=a[i];
            a[i]=a[parent(i)];
            a[parent(i)]=t;
            map.put(a[i],i);
            map.put(a[parent(i)],parent(i));
            i=parent(i);
            System.out.println("swapping");
        }
    }

    boolean contains(int key){
        return map.containsKey(key);
    }

    boolean isEmpty(){
        return size==0;
    }

    void decreaseKey(int k, int v) {
        Integer index = map.get(k);
        if (index == null) return;
        a[index] = v;
        int i = index;
        while (i>0 && a[parent(i)]<a[i]){
            int t=a[i];
            a[i]=a[parent(i)];
            a[parent(i)]=t;
            map.put(a[i],i);
            map.put(a[parent(i)],parent(i));
            i=parent(i);
            System.out.println("swapping");
        }
    }

    int extractMax(){
        if(size==0) return Integer.MIN_VALUE;
        int max=a[0];
        a[0]=a[size-1];
        size--;
        buildHeap(0);
        return max;
    }

    void printHeap(){
        System.out.println(Arrays.toString(a));
    }

    void heapify(int b[]){
        int j=0;
        for(j=0;j<b.length;j++){
            a[j]=b[j];
            map.put(a[j],j);
        }
        size=j;
        for(int i=(b.length/2);i>=0;i--){
            buildHeap(i);
        }
    }

    public static void main(String[] args) {
        int a[]=new int[]{4,8,2,9,7,15,1};
        MaxHeap heap=new MaxHeap(20);
        heap.heapify(a);
        //heap.printHeap();
        System.out.println(heap.contains(15));
        heap.add(22);
        heap.decreaseKey(9,90);
        heap.printHeap();
        System.out.println(heap.extractMax());
        heap.printHeap();
    }
}
