package coding.ds.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {

    private T stack[];
    private int size;
    private int top;

    public Stack(Class<T> tClass, int size){
        this.size = size;
        stack = (T[]) Array.newInstance(tClass, size);
        top = -1;
    }

    public void push(T element){
        if(isFull()) throw new IndexOutOfBoundsException("Stack Full");
        stack[++top] = element;
    }

    public T pop(){
        if(isEmpty()) throw new EmptyStackException();
        return stack[top--];
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public boolean isFull(){
        return top+1 == size;
    }

    public T peek(){
        if(isEmpty())   return null;
        return stack[top];
    }

    public int size(){
        return top+1;
    }
}
