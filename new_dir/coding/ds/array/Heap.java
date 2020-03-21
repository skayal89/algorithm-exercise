package coding.ds.array;

import coding.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.Comparator;

public class Heap<T> {
    int capacity, size;
    T heap[];
    Comparator<T> comparator;

    public Heap(Class<T> tClass, int capacity, Comparator<T> comparator){
        this.size=0;
        this.capacity=capacity;
        heap = (T[]) Array.newInstance(tClass, capacity);
        this.comparator=comparator;
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

    public void buildHeap(int i){
        int l=left(i);
        int r=right(i);
        int criteria=i; // largest or smallest

        if(l<size && comparator.compare(heap[criteria], heap[l])>0)   criteria=l;
        if(r<size && comparator.compare(heap[criteria], heap[r])>0)   criteria=r;

        if (criteria != i){
            T t=heap[criteria];
            heap[criteria]=heap[i];
            heap[i]=t;

            buildHeap(criteria);
        }
    }

    public void add(T element){
        if(size==capacity){
            System.err.println("Heap full");
            return;
        }

        int i=size;
        heap[size++]=element;

        while(i>0 && comparator.compare(heap[parent(i)], heap[i])>0){
            T t=heap[parent(i)];
            heap[parent(i)]=heap[i];
            heap[i]=t;
            i=parent(i);
        }
        print();
    }

    private void heapify(T[] elements, int n){
        for(int i=0;i<n;i++){
            heap[size++]=elements[i];
        }
        for(int j=(size/2);j>=0;j--){
            buildHeap(j);
        }
    }

    private void print(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap hmax=new Heap(Integer.class, 10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        hmax.add(10);
        hmax.add(20);
        hmax.add(5);
        hmax.add(7);
        hmax.add(17);
        hmax.add(55);

        Heap hmin=new Heap(Integer.class, 10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        hmin.add(10);
        hmin.add(20);
        hmin.add(5);
        hmin.add(7);
        hmin.add(17);
        hmin.add(2);


        Integer[] a=new Integer[]{10,20,5,7,17,55};
        Heap hmaxt=new Heap(Integer.class, 10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        hmaxt.heapify(a, a.length);
        hmaxt.print();
    }
}
