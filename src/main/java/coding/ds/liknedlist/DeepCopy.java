package coding.ds.liknedlist;

import coding.coding.model.LinkedListNode;
import coding.coding.model.RandomListNode;
import coding.util.LinkedListUtil;

public class DeepCopy {
    public static void main(String[] ar){
        LinkedListNode l=new LinkedListNode(10);
        l.next=new LinkedListNode(20);
        l.next.next=new LinkedListNode(30);
        l.next.next.next=new LinkedListNode(40);
        l.next.next.next.next=new LinkedListNode(50);
        LinkedListUtil.print(l);

        RandomListNode r=new RandomListNode(1);
        r.next=new RandomListNode(2);
        r.next.next=new RandomListNode(3);
        r.next.next.next=new RandomListNode(4);
        r.next.next.next.next=new RandomListNode(5);
        r.random=r.next.next;
        r.next.random=r;
        r.next.next.random=r.next.next.next.next;
        r.next.next.next.random=r.next.next;
        r.next.next.next.next.random=r.next;
        LinkedListUtil.print(r);
        LinkedListUtil.print(copyRandomList(r));
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)  return null;
        RandomListNode curr=head;
        while(curr!=null){
            RandomListNode t=curr.next;
            RandomListNode n=new RandomListNode(curr.label);
            curr.next=n;
            n.next=t;
            curr=t;
        }
        curr=head;
        RandomListNode clone=head,cloneHead=null;
        while(curr!=null){
            if(cloneHead==null){
                cloneHead=curr.next;
            }
            clone=curr.next;
            curr.next.random=curr.random.next;
            RandomListNode t=clone.next;
            if(clone.next!=null) {
                clone.next = clone.next.next;
            }
            curr.next=t;
            curr=t;
        }
        return cloneHead;
    }

}
