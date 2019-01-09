package coding.ds.liknedlist;

import coding.coding.model.LinkedListNode;

public class MergeLinkedLists {
    static LinkedListNode mergeI(LinkedListNode h1, LinkedListNode h2){
        LinkedListNode dummy=new LinkedListNode(0);
        LinkedListNode tail=dummy;

        while (h1!=null && h2!=null){
            if(h1.data<=h2.data){
                tail.next=h1;
                h1=h1.next;
            }
            else{
                tail.next=h2;
                h2=h2.next;
            }
            tail=tail.next;
        }
        if(h1!=null){
            tail.next=h1;
        }
        if(h2!=null){
            tail.next=h2;
        }
        return dummy.next;
    }

    static LinkedListNode mergeR(LinkedListNode a, LinkedListNode b){
        if(a==null) return b;
        if(b==null) return a;
        if(a.data<=b.data){
            a.next=mergeR(a.next,b);
            return a;
        }
        else {
            b.next=mergeR(a,b.next);
            return b;
        }
    }

    public static void main(String[] args) {
        LinkedListNode h1=LinkedListNode.create(5,10,15);
        LinkedListNode h2=LinkedListNode.create(2,3,20,35);
        LinkedListNode hI=mergeI(h1,h2);
        LinkedListNode hR=mergeR(h1,h2);
        hI.print();
        hR.print();
    }
}
