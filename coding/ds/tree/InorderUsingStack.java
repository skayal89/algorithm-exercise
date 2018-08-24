package coding.ds.tree;

import coding.coding.model.TreeNode;

import java.util.Stack;

public class InorderUsingStack {
    public static void inorder(TreeNode t){
        TreeNode curr=t;
        Stack<TreeNode> s=new Stack<TreeNode>();
        while(curr!=null){
            while (curr.left!=null){
                s.push(curr);
                curr=curr.left;
            }
            System.out.println(curr.data);
            if(curr.right!=null){
                curr=curr.right;
            }
            else {
                if(s.empty())   return;
                while (!s.empty()){
                    TreeNode temp=s.pop();
                    System.out.println(temp.data);
                    if(s.empty() && temp.right==null)  return;
                    if(temp.right!=null){
                        curr=temp.right;
                        break;
                    }
                }
            }
        }
    }

    public static void inorder2(TreeNode t){
        TreeNode curr=t;
        Stack<TreeNode> s=new Stack<TreeNode>();
        while(curr!=null){
            s.push(curr);
            if(curr.left!=null){
                curr=curr.left;
            }
            else {
                TreeNode x=s.pop();
                System.out.println(x.data);
                while (!s.empty() && curr.right==null){
                    curr=s.pop();
                    System.out.println(curr.data);
                }
                if(s.empty() && curr.right==null){
                    break;
                }
                if (curr.right!=null){
                    curr=curr.right;
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
    }
}
