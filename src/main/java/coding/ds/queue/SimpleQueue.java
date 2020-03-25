package coding.ds.queue;

import java.lang.reflect.Array;

public class SimpleQueue<T> {

    private T queue[];
    private int front, rear;
    private int size, capacity;

    public SimpleQueue(Class<T> tClass, int size){
        this.capacity = size;
        rear = -1;
        front = 0;
        this.size = 0;
        queue = (T[]) Array.newInstance(tClass,capacity);
    }

    public boolean isEmpty(){
        return rear == -1 || size == 0 || front > rear;
    }

    public boolean isFull(){
        return rear == capacity - 1;
    }

    public int getSize(){
        return size;
    }

    public void add(T element){
        if(isFull())    throw new IndexOutOfBoundsException("Queue is full");
        queue[++rear] = element;
        size++;
    }

    public T poll(){
        if(isEmpty())   throw new IndexOutOfBoundsException("Queue is empty");
        size--;
        return queue[front++];
    }

    public T peek(){
        if(isEmpty())   return null;
        return queue[front];
    }
}
