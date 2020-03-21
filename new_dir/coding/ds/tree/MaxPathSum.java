package coding.ds.tree;

import coding.coding.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MaxPathSum {

    static int maxPathSum(TreeNode t, Density.Height height){
        Density.Height lh=new Density.Height(), rh=new Density.Height();
        if(t==null) return 0;
        int lpath=maxPathSum(t.left,lh);
        int rpath=maxPathSum(t.right,rh);
        height.height=1+Math.max(lh.height,rh.height);
        return max(1+lh.height+rh.height,lpath,rpath);
    }

    static int max(int a, int b, int c){
        return Math.max(a,Math.max(b,c));
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.left.left=new TreeNode(4);
        t.left.left.left=new TreeNode(10);
        t.left.left.left.right=new TreeNode(17);
        t.left.right=new TreeNode(5);
        t.left.right.left=new TreeNode(6);
        t.right=new TreeNode(3);
        t.right.right=new TreeNode(7);
        t.right.right.right=new TreeNode(9);
        System.out.println(maxPathSum(t,new Density.Height()));

        List<Integer> l=new LinkedList<Integer>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        int[][] r=new int[3][];
        int a[]=l.stream().mapToInt(Integer::intValue).toArray();
        r[0]=a;
    }
}
