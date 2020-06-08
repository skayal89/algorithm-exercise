package coding.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
// few test cases failing
class KWeakestRows {
    private int[] kWeakestRows(int[][] mat, int k) {
        Entry[] ranks = buildRanks(mat);
        Heap<Entry> entryHeap = new Heap<>(Entry.class, k);
        heapify(entryHeap, ranks);
        return getWeakest(entryHeap, k);
    }

    private Entry[] buildRanks(int[][] a) {
        Entry[] e = new Entry[a.length];
        for (int i = 0; i < a.length; i++) {
            e[i] = new Entry(i, countSoldiers(a[i]));
            System.out.println(i + " " + countSoldiers(a[i]));
        }
        return e;
    }

    private void heapify(Heap<Entry> entryHeap, Entry[] ranks) {
        for (Entry entry : ranks) {
            entryHeap.add(entry);
        }
    }

    private int[] getWeakest(Heap<Entry> entryHeap, int k) {
        int[] res = new int[k];
        for (int i = k - 1; i >= 0 && !entryHeap.isEmpty(); i--) {
            res[i] = entryHeap.poll().index;
        }
        return res;
    }

    private int countSoldiers(int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    class Entry implements Comparable<Entry> {
        int index, rank;

        Entry(int i, int r) {
            index = i;
            rank = r;
        }

        public int compareTo(Entry e) {
            if (e == null) return -1;
            if (this.rank == e.rank) {
                return this.index - e.index;
            }
            return this.rank - e.rank;
        }
    }

    class Heap<T extends Comparable<T>> {
        T[] heap;
        int size;
        int capacity;

        Heap(Class<T> tClass, int k) {
            this.capacity = k;
            this.size = 0;
            heap = (T[]) Array.newInstance(tClass, capacity);
        }

        void add(T element) {
            if (element == null) return;
            if (isFull()) {
                if (element.compareTo(peek()) <= 0) {
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

        T poll() {
            if (isEmpty()) return null;
            T removed = peek();
            heap[0] = heap[--size];
            shiftDown(0);
            return removed;
        }

        boolean isEmpty() {
            return size <= 0;
        }

        boolean isFull() {
            return size == capacity;
        }

        T peek() {
            if (isEmpty()) return null;
            return heap[0];
        }

        private int parent(int i) {
            return i / 2;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        private void shiftUp(int i) {
            while (i > 0 && heap[i].compareTo(heap[parent(i)]) > 0) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void shiftDown(int i) {
            if (i >= size) return;
            int child = i;
            int l = left(i);
            int r = right(i);
            if (isValid(child) && isValid(l) && heap[l].compareTo(heap[child]) > 0) {
                child = l;
            }
            if (isValid(child) && isValid(r) && heap[r].compareTo(heap[child]) > 0) {
                child = r;
            }
            if (child != i) {
                swap(i, child);
                shiftDown(child);
            }
        }

        private boolean isValid(int i) {
            return i >= 0 && i < size && heap[i] != null;
        }

        private void swap(int i, int j) {
            T t = heap[i];
            heap[i] = heap[j];
            heap[j] = t;
        }
    }

    public static void main(String[] args) {
        KWeakestRows kWeakestRows = new KWeakestRows();
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows.kWeakestRows(mat, k)));
        k = 4;
        System.out.println(Arrays.toString(kWeakestRows.kWeakestRows(mat, k)));
        int[][] mat2 = {{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}};
        k = 2;
        System.out.println(Arrays.toString(kWeakestRows.kWeakestRows(mat2, k)));
        k = 3;
        System.out.println(Arrays.toString(kWeakestRows.kWeakestRows(mat2, k)));
        int[][] mat3 = {{1, 1, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0}};
        k = 4;
        System.out.println(Arrays.toString(kWeakestRows.kWeakestRows(mat3, k)));
    }
}
