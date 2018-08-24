package coding.ds.stack;

import coding.coding.model.DoublyLinkedListNode;
import coding.util.LinkedListUtil;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class AugmentedStack {

    DoublyLinkedListNode head, mid;
    int size;

    AugmentedStack(){
        size=0;
        head=mid=null;
    }

    void push(int x){
        DoublyLinkedListNode node=new DoublyLinkedListNode(x);
        node.next=head;
        if(head!=null) {
            head.prev=node;
        }
        head = node;
        size++;
        if(size==1){
            mid=head;
        }
        else if(size%2!=0){
            mid=mid.prev;
        }
        if(mid!=null){
            System.out.println("[Log] mid: "+mid.data);
        }
    }

    int pop(){
        int x=head.data;
        head=head.next;
        if(head!=null) {
            head.prev = null;
        }
        size--;
        System.out.println("size: "+size);
        if(size==0){
            mid=null;
        }
        else {
            if(size%2==0){
                mid=mid.next;
            }
        }
        if(mid!=null){
            System.out.println("[Log] mid: "+mid.data);
        }
        return x;
    }

    int findMid(){
        if(mid==null){
            return -1;
        }
        return mid.data;
    }

    int deleteMid(){
        if(mid!=null && mid.prev!=null) {
            mid.prev.next = mid.next;
        }
        if(mid!=null && mid.prev!=null) {
            mid.next.prev=mid.prev;
        }
        return mid.data;
    }

    public static void main(String ar[]){
        AugmentedStack stack=new AugmentedStack();
        //stack.head=new DoublyLinkedListNode(1);
        stack.push(1);
        System.out.println("mid:"+stack.findMid());
        stack.push(2);
        System.out.println("mid:"+stack.findMid());
        stack.push(3);
        LinkedListUtil.print(stack.head);
        System.out.println("mid:"+stack.findMid());
        System.out.println(stack.pop());
        LinkedListUtil.print(stack.head);
    }
}
