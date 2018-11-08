package coding.ds.tree;

import coding.coding.model.TreeNode;

import java.util.Stack;

public class InorderUsingStack {

    static void inorder3(TreeNode t){
        if(t==null) return;
        TreeNode curr=t;
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(curr);
        while (!s.empty()){
            while (curr!=null && curr.left!=null){
                s.push(curr.left);
                curr=curr.left;
            }
            while (!s.empty()){
                TreeNode temp=s.pop();
                System.out.println(temp.data);
                if(temp.right!=null){
                    curr=temp.right;
                    s.push(curr);
                    break;
                }
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
        //inorder2(t);
        //inorder3(t);
        postOrder(t);
    }
}
