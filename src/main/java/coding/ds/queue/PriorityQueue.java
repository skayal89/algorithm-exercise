package coding.ds.queue;

import java.lang.reflect.Array;
import java.util.Comparator;

public class PriorityQueue<T> {

    private T[] heap;
    private Comparator<T> comparator;
    private int size;
    private int capacity;

    PriorityQueue(Class<T> tClass, int capacity, Comparator<T> comparator){
        heap = (T[]) Array.newInstance(tClass,capacity);
        this.comparator = comparator;
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(T element){
        if(element == null){
            throw new NullPointerException("Null can't be inserted");
        }
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }
        int i = size;
        heap[i] = element;
        shiftUp(i);
        size++;
    }

    public T poll(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        T removedElement = heap[0];
        heap[0] = heap[--size];
        shiftDown(0);
        return removedElement;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    private int parent(int i){
        return i/2;
    }

    private int left(int i){
        return 2*i+1;
    }

    private int right(int i){
        return 2*i+2;
    }

    private boolean isValid(int i){
        return i >=0  && i < size && heap[i] != null;
    }

    private void shiftUp(int i){
        while (i > 0 && comparator.compare(heap[i],heap[parent(i)])<0){
            swap(i,parent(i));
            i = parent(i);
        }
    }

    private void shiftDown(int i){
        int child = i;
        int l = left(i);
        int r = right(i);
        if(isValid(child) && isValid(l) && comparator.compare(heap[child],heap[l])>0){
            child = l;
        }
        if(isValid(child) && isValid(r) && comparator.compare(heap[child],heap[r])>0){
            child = r;
        }
        if(child != i){
            swap(child,i);
            shiftDown(child);
        }
    }

    private void swap(int i, int j){
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    public static void main(String[] args) {
        System.out.println("Max Heap");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Integer.class,5, (o1, o2) -> o2-o1);
        maxHeap.add(7);
        maxHeap.add(9);
        maxHeap.add(3);
        maxHeap.printHeap();
        System.out.println(maxHeap.poll());
        maxHeap.printHeap();
        maxHeap.add(17);
        System.out.println(maxHeap.poll());
        maxHeap.add(9);
        maxHeap.add(13);
        maxHeap.add(1);
        maxHeap.printHeap();

        System.out.println("Min Heap");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Integer.class,5, (o1, o2) -> o1-o2);
        minHeap.add(7);
        minHeap.add(9);
        minHeap.add(3);
        minHeap.printHeap();
        System.out.println(minHeap.poll());
        minHeap.printHeap();
        minHeap.add(17);
        System.out.println(minHeap.poll());
        minHeap.add(9);
        minHeap.add(13);
        minHeap.add(1);
        minHeap.printHeap();
    }
}
