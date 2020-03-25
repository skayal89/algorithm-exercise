package coding.ds.liknedlist;

public interface LinkedList<T> {
    void add(T element, int position); // insert an element after the given position
    boolean remove(T element); // returns the position
    int size();
    boolean isEmpty();
    void removeAll();
    T getFirst();
    T getLast();
}
