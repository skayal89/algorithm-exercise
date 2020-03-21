package coding.ds.tree;

import coding.coding.model.TreeNode;

import java.util.LinkedList;

public class PrintAncestors {

    static void printAncestors(TreeNode t,int x){
        LinkedList<Integer> list=new LinkedList<>();
        build(t,x,list);
        System.out.println(list);
    }

    static boolean build(TreeNode t, int x, LinkedList<Integer> list){
        if(t==null) return false;
        if(t.data==x)   return true;
        boolean l=build(t.left,x,list);
        boolean r=build(t.right,x,list);
        if(l || r){
            list.addFirst(t.data);
        }
        return l || r;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(4);
        t.right=new TreeNode(5);
        t.left.left=new TreeNode(2);
        t.left.right=new TreeNode(3);
        t.left.left.left=new TreeNode(7);

        printAncestors(t,7);
    }
}
