package coding.ds.tree;

import coding.coding.model.TreeNode;

public class MorrisInorder {

    static void inorder(TreeNode t){
        TreeNode curr=t;
        TreeNode p=null;

        while(curr!=null){
            if(curr.left==null){
                System.out.print(curr.data+" ");
                curr=curr.right;
            }
            else {
                p=curr.left;
                while (p.right!=null && p.right.data!=curr.data){
                    p=p.right;
                }
                if(p.right==null){
                    p.right=curr;
                    curr=curr.left;
                }
                else if(p.right.data==curr.data){
                    p.right=null;
                    System.out.print(curr.data+" ");
                    curr=curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        int in[]=new int[]{17,27,4,2,5,10,8,12,7,1,3};
        int pre[]=new int[]{1,2,4,17,27,5,7,8,10,12,3};
        TreeNode t=ConstructTree.construct(in,pre);
        inorder(t);
    }
}
