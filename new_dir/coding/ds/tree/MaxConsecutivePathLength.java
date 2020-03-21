package coding.ds.tree;

import coding.coding.model.TreeNode;

public class MaxConsecutivePathLength {

    public static int longestConsecutive(TreeNode root)
    {
        return path(root,null);
    }

    static int path(TreeNode t, Integer p){
        if(t==null) return 0;
        int l=path(t.left,t.data);
        int r=path(t.right,t.data);
        if(p==null || (t.data==p+1)){
            return 1+Math.max(l,r);
        }
        return Math.max(l,r);
    }

    public static void main(String[] args) {
//        TreeNode t=new TreeNode(1);
//        t.left=new TreeNode(2);
//        t.left.left=new TreeNode(3);
//        t.left.left.left=new TreeNode(8);
//        t.right=new TreeNode(4);
//        t.right.right=new TreeNode(6);
//        t.right.left=new TreeNode(5);
//        t.right.right.left=new TreeNode(7);

        TreeNode t=new TreeNode(6);
        t.right=new TreeNode(9);
        t.right.left=new TreeNode(7);
        t.right.right=new TreeNode(10);
        t.right.right.right=new TreeNode(11);
        System.out.println(longestConsecutive(t));
    }
}
