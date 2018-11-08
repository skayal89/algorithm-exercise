package coding.ds.liknedlist;

import coding.coding.model.LinkedListNode;

public class GroupReverse {

    static LinkedListNode reverse(LinkedListNode head, int k){
        if(k<2 || head==null || head.next==null)    return head;
        LinkedListNode p=head, c=head.next, t=null;
        int count=1;
        while(count!=k && c!=null){
            t=c.next;
            c.next=p;
            p=c;
            c=t;
            count++;
        }
        head.next=reverse(c,k);
        return p;
    }

    public static void main(String[] args) {
        LinkedListNode h=LinkedListNode.create(1,2,3,4,5,6,7,8);
        h.print();
        h=reverse(h,10);
        h.print();
    }
}
