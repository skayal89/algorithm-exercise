package coding.coding.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data){
        this.data=data;
        this.next=null;
    }

    public static LinkedListNode create(int...a){
        LinkedListNode head=null;
        for (int d : a) {
            head=insertLast(head,d);
        }
        return head;
    }

    public static LinkedListNode insertLast(LinkedListNode head, int data){
        if(head==null){
            head=new LinkedListNode(data);
        }
        else{
            head.next=insertLast(head.next,data);
        }
        return head;
    }

    public void print(){
        LinkedListNode p=this;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }
}
