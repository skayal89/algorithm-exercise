package coding.ds.liknedlist;

import coding.coding.model.SingleLinkedListNode;

public class SinglyLinkedList<T> implements LinkedList<T> {

    private SingleLinkedListNode head;
    private int length;

    public SinglyLinkedList(){
        head = null;
        length = 0;
    }

    @Override
    public void add(T element, int position) {
        SingleLinkedListNode node = createNode(element);
        if(position == 0){
            node.next = head;
            head = node;
            length++;
            return;
        }
        SingleLinkedListNode temp = head;
        int countNodes = 0;
        while(temp != null){
            if(countNodes == position-1)  break;
            temp = temp.next;
            countNodes++;
        }
        if(temp == null)    return;
        SingleLinkedListNode tempNext = temp.next;
        temp.next = node;
        node.next = tempNext;
        length++;
    }

    @Override
    public boolean remove(T element) {
        SingleLinkedListNode temp = head;
        SingleLinkedListNode prev = null;
        while(temp != null){
            if(temp.data.equals(element)){
                if(prev == null){
                    head = head.next;
                }
                else {
                    prev.next = temp.next;
                }
                length--;
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void removeAll() {
        head = null;
    }

    @Override
    public T getFirst() {
        if(isEmpty())   return null;
        return (T) head.data;
    }

    @Override
    public T getLast() {
        if(isEmpty())   return null;
        SingleLinkedListNode<T> temp = head;
        while(temp != null && temp.next != null){
            temp = temp.next;
        }
        return temp.data;
    }

    private SingleLinkedListNode createNode(T data){
        return new SingleLinkedListNode<T>(data);
    }
}
