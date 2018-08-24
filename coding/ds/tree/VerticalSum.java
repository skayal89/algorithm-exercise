package coding.ds.tree;

import coding.coding.model.DoublyLinkedListNode;
import coding.coding.model.TreeNode;
import coding.util.LinkedListUtil;

public class VerticalSum {

    static void verticalSum(TreeNode t){
        DoublyLinkedListNode list=new DoublyLinkedListNode(0);
        sumList(t,list);
        while (list.prev!=null){
            list=list.prev;
        }
        LinkedListUtil.print(list);
    }

    static void sumList(TreeNode t, DoublyLinkedListNode l){
        if(t==null) return;
        l.data+=t.data;
        if(t.left!=null){
            if(l.prev==null){
                l.prev=new DoublyLinkedListNode(0);
                l.prev.next=l;
            }
            sumList(t.left,l.prev);
        }
        if(t.right!=null){
            if(l.next==null){
                l.next=new DoublyLinkedListNode(0);
                l.next.prev=l;
            }
            sumList(t.right,l.next);
        }
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(5);
        t.left.left=new TreeNode(3);
        t.left.left.right=new TreeNode(7);
        t.left.right=new TreeNode(4);
        t.right.left=new TreeNode(6);

        verticalSum(t);
    }
}
