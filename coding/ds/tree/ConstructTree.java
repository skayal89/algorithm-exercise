package coding.ds.tree;

import coding.coding.model.TreeNode;

import java.util.Arrays;

public class ConstructTree {

    private static TreeNode constructFromPreIn(int[] in,int[] pre, Index index, int low, int high){
        TreeNode t=null;
        if(low<=high){
            t=new TreeNode(pre[index.i]);
            int j=search(in, low, high, pre[index.i]);
            index.i++;
            if(j==-1)   return t;
            t.left=constructFromPreIn(in, pre, index, low, j-1);
            t.right=constructFromPreIn(in, pre, index, j+1, high);
        }
        return t;
    }

    static TreeNode construct(int[] inorder,int[] preorder){
        return constructFromPreIn(inorder,preorder,new Index(),0,inorder.length-1);
    }

    static int search(int a[], int l, int h, int target){
        for (int i = l; i <= h; i++) {
            if(a[i]==target)    return i;
        }
        return -1;
    }

    static class Index{
        int i;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(7);
        t.left=new TreeNode(9);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(2);
        t.left.right=new TreeNode(10);
        t.left.right.left=new TreeNode(6);
        t.right.right=new TreeNode(21);

        int in[]=new int[]{2,9,6,10,7,3,21};
        int pre[]=new int[]{7,9,2,10,6,3,21};
        TreeNode t1=constructFromPreIn(in,pre,new Index(),0,in.length-1);
        InorderUsingStack.inorder(t1);
    }
}
