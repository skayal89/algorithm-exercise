package coding.ds.queue;

import java.util.Arrays;
import java.util.Comparator;

public class KLargestElement {

    public int[] kLargestElements(int[] a, int k){
        MinHeap minHeap = new MinHeap(k);
        addToHeap(minHeap, a);
        return extractKElements(minHeap, k);
    }

    public static void main(String[] args) {
        KLargestElement kLargestElement = new KLargestElement();
        int a[] = new int[]{16, 3, 9, 17, 1, 2, 15, 10};
        System.out.println(Arrays.toString(kLargestElement.kLargestElements(a, 3)));
        System.out.println(Arrays.toString(kLargestElement.kLargestElements(a, 2)));
        System.out.println(Arrays.toString(kLargestElement.kLargestElements(a, 5)));
    }

    private void addToHeap(MinHeap minHeap, int[] a) {
        for(int i : a){
            minHeap.add(i);
        }
    }

    private int[] extractKElements(MinHeap minHeap, int k) {
        int res[] = new int[k];
        for(int i = k-1; i>=0 && !minHeap.isEmpty(); i--){
            res[i] = minHeap.poll();
        }
        return res;
    }

    class MinHeap {
        Integer[] heap;
        int capacity;
        int size;

        MinHeap(int k){
            heap = new Integer[k];
            capacity = k;
            size = 0;
        }

        public void add(int element){
            if(isFull()){
                if(peek()<element) {
                    heap[0] = element;
                    shiftDown(0);
                }
                return;
            }
            int i = size;
            heap[i] = element;
            shiftUp(i);
            size++;
        }

        public Integer poll(){
            if(isEmpty())   return null;
            Integer removed = heap[0];
            heap[0] = heap[--size];
            shiftDown(0);
            return removed;
        }

        public boolean isEmpty() {
            return size <= 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public Integer peek(){
            if(isEmpty())   return null;
            return heap[0];
        }

        private void shiftUp(int i){
            while (i > 0 && heap[i]<heap[parent(i)]){
                swap(i,parent(i));
                i = parent(i);
            }
        }

        private void shiftDown(int i){
            int smaller = i;
            int l = left(i);
            int r = right(i);
            if(isValid(smaller) && isValid(l) && heap[l]<heap[smaller]){
                smaller = l;
            }
            if(isValid(smaller) && isValid(r) && heap[r]<heap[smaller]){
                smaller = r;
            }
            if(smaller != i){
                swap(i,smaller);
                shiftDown(smaller);
            }
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

        private void swap(int i, int j){
            int t = heap[i];
            heap[i] = heap[j];
            heap[j] = t;
        }

        private boolean isValid(int i){
            return i>=0 && i<size && heap[i]!=null;
        }


    }


}
