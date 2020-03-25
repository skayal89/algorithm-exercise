package coding.coding.model;

public class SingleLinkedListNode<T> {
    public T data;
    public SingleLinkedListNode<T> next;

    public SingleLinkedListNode(T data) {
        this.data = data;
        next = null;
    }
}
