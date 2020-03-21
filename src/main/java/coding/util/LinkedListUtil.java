package coding.util;

import coding.coding.model.DoublyLinkedListNode;
import coding.coding.model.LinkedListNode;
import coding.coding.model.RandomListNode;

public class LinkedListUtil {
    public static int size(LinkedListNode l){
        if(l==null) return 0;
        return 1+size(l.next);
    }
    public static int size(DoublyLinkedListNode l){
        if(l==null) return 0;
        return 1+size(l.next);
    }
    public static void print(LinkedListNode l){
        LinkedListNode p=l;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }
    public static void print(DoublyLinkedListNode l){
        DoublyLinkedListNode p=l;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }
    public static void print(RandomListNode l){
        RandomListNode p=l;
        while(p!=null){
            System.out.print(p.label+"->["+p.random.label+"] ");
            p=p.next;
        }
        System.out.println();
    }
}
