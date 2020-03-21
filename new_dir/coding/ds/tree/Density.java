package coding.ds.tree;

import coding.coding.model.TreeNode;

public class Density {

    static int densityUtil(TreeNode t, Height h){
        if(t==null) return 0;
        Height lh=new Height(),rh=new Height();
        int size=1+ densityUtil(t.left,lh)+ densityUtil(t.right,rh);
        h.height=1+ Math.max(lh.height,rh.height);
        return size;
    }

    static double density(TreeNode t){
        Height h=new Height();
        int s=densityUtil(t,h);
        return (double) s/h.height;
    }

    static class Height{
        int height;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(7);
        t.left=new TreeNode(4);
        t.right=new TreeNode(10);
        t.left.left=new TreeNode(5);
        t.left.right=new TreeNode(9);
        //t.left.right.left=new TreeNode(17);
        t.right.left=new TreeNode(8);
        t.right.right=new TreeNode(13);

        System.out.println(density(t));
    }
}
