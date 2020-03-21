package coding.ds.tree;

import coding.coding.model.TreeNode;

import java.util.Stack;

public class IterativeInorderPostorder {

    static void inorder(TreeNode t){
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode curr=t;
        while (curr!=null){
            while (curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            while (!s.empty() && curr==null){
                TreeNode temp = s.pop();
                System.out.print(temp.data+" ");
                curr=temp.right;
            }
        }
    }

    static void inorder2(TreeNode t){
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode curr=t;
        while (curr!=null || !s.empty()){
            if (curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp = s.pop();
                System.out.print(temp.data+" ");
                curr=temp.right;
            }
        }
    }

    static void postOrder(TreeNode root)
    {
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode curr=root, p=null;
        while(curr!=null){
            while(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            while(!s.empty()){
                TreeNode t=s.peek();
                if((t.right==null) || (p!=null && t.right.data==p.data)){
                    p=s.pop();
                    System.out.print(p.data+" ");
                }
                else {
                    curr=t.right;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(7);
        t.left=new TreeNode(4);
        t.right=new TreeNode(10);
        t.left.left=new TreeNode(5);
        t.left.right=new TreeNode(9);
        t.left.right.left=new TreeNode(17);
        t.right.left=new TreeNode(8);
        t.right.right=new TreeNode(13);
        inorder2(t);
        System.out.println();
        inorder(t);
        //postOrder(t);
    }
}
