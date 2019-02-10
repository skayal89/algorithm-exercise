package coding.ds.tree;

import coding.coding.model.TreeNode;

/*
 * size of largest subtree which is a perfect binary tree
 * a binary tree is perfect iff a node has 0 or 2 childs and
 * all leaves are at same level
 */
public class LargestPerfectBinaryTree {

    static int res_size;
    int largestPerfectTree(TreeNode r){
        res_size=0;
        util(r);
        return res_size;
    }

    Data util(TreeNode r){
        if(r==null){
            return new Data(0,0);
        }
        if(r.left==null && r.right==null){
            return new Data(1,1);
        }
        Data dl=util(r.left);
        Data dr=util(r.right);
        if(r.left!=null && r.right!=null) {
            if (dl.depth == dr.depth) {
                int s=dl.size+dr.size+1;
                if(res_size<s)   res_size=s;
                return new Data(s, dl.depth+1);
            }
            else{
                int child_size=Math.max(dl.size,dr.size);
                int single_depth = Math.min(dl.depth,dr.depth); // need to consider smaller depth between two childs as leaves for this root
                int single_size = Math.min(dl.size,dr.size); // need to return smaller size between two childs
                if(res_size<Math.min(child_size, single_size+1))    res_size=Math.min(child_size, single_size+1);
                return new Data(2*single_size+1, single_depth+1);
            }
        }
        if(res_size<1)   res_size=1;
        return new Data(1,1);
    }

    class Data{
        int size; // track the size of perfect binary subtree
        int depth; // track the depth of leaf node
        Data(int size, int depth){
            this.size=size;
            this.depth=depth;
        }
    }

    TreeNode sample1(){
        /*
                      1
                   /     \
                  2       3
                  \    /     \
                  4   5       6
                     / \    /  \
                    7  8   9   10
                               /
                              14
        */
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.right=new TreeNode(4);
        t.right.left=new TreeNode(5);
        t.right.right=new TreeNode(6);
        t.right.left.left=new TreeNode(7);
        t.right.left.right=new TreeNode(8);
        t.right.right.left=new TreeNode(9);
        t.right.right.right=new TreeNode(10);
        t.right.right.right.left=new TreeNode(11);
        return t;
    }

    public static void main(String[] args) {
        LargestPerfectBinaryTree obj=new LargestPerfectBinaryTree();
        System.out.println(obj.largestPerfectTree(obj.sample1()));


    }
}
