package coding.algo.geometry;

import java.util.Stack;

public class ExtendedStack<T> extends Stack<T> {
    public synchronized T nextToTop(){
        T curr=pop();
        T prev=peek();
        push(curr);
        return prev;
    }
}
