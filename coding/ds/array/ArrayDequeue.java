package coding.ds.array;

public class ArrayDequeue {
    int front, rear;
    int q[];
    int size;

    public ArrayDequeue(int size) {
        this.size = size;
        q=new int[size];
        front=-1;
        rear=-1;
    }
}
