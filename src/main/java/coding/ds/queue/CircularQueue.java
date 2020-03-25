package coding.ds.queue;

import java.lang.reflect.Array;

public class CircularQueue<T> {

    private T queue[];
    private int front, rear;
    private int size, capacity;

    public CircularQueue(Class<T> tClass, int size){
        this.capacity = size;
        front = rear = -1;
        this.size = 0;
        queue = (T[]) Array.newInstance(tClass,capacity);
    }

    public boolean isEmpty(){
        return rear==-1 || size() == 0;
    }

    public boolean isFull(){
        return front == (rear+1)%capacity;
    }

    public void add(T element){
        if(isFull())    throw new IndexOutOfBoundsException("Queue is Full");
        rear = (rear+1)%capacity;
        queue[rear] = element;
        size++;
        if(front == -1) front = 0;
    }

    public T poll(){
        if(isEmpty())   throw new IndexOutOfBoundsException("Queue is empty");
        T element = queue[front];
        front = (front +1)%capacity;
        size--;
        return element;
    }

    public int size(){
        return size;
    }

    public T peek(){
        if(!isEmpty())  return queue[rear];
        return null;
    }
}
