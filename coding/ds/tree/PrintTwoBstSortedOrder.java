package coding.ds.tree;

import coding.coding.model.TreeNode;

import java.util.Stack;

import static coding.util.TreeUtil.inorder;

/*
https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
 */
public class PrintTwoBstSortedOrder {
    static void printInSortedOrder(TreeNode r1, TreeNode r2){
        Stack<TreeNode> s1=new Stack<>(), s2=new Stack<>();
        TreeNode c1=r1, c2=r2;
        while(c1!=null || c2!=null || !s1.empty() || !s2.empty()){
            if(c1!=null || c2!=null){
                if(c1!=null){
                    s1.push(c1);
                    c1=c1.left;
                }
                if(c2!=null){
                    s2.push(c2);
                    c2=c2.left;
                }
            }
            else {
                if(!s1.empty() && !s2.empty()){
                    if(s1.peek().data<s2.peek().data){
                        c1=s1.pop();
                        System.out.println(c1.data);
                        c1=c1.right;
                    }
                    else if(s2.peek().data<s1.peek().data){
                        c2=s2.pop();
                        System.out.println(c2.data);
                        c2=c2.right;
                    }
                }
                else{
                    TreeNode t=null;
                    if(s1.empty()){
                        while (!s2.empty()){
                            t=s2.pop();
                            System.out.println(t.data);
                            inorder(t.right);
                        }
                    }
                    if(s2.empty()){
                        while (!s1.empty()){
                            t=s1.pop();
                            System.out.println(t.data);
                            inorder(t.right);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(30);
        t1.left=new TreeNode(15);
        t1.right=new TreeNode(60);
        t1.left.right=new TreeNode(22);

        TreeNode t2=new TreeNode(25);
        t2.left=new TreeNode(20);
        t2.right=new TreeNode(50);
        t2.left.left=new TreeNode(12);
        t2.right.left=new TreeNode(39);

        printInSortedOrder(t1,t2);
    }
}
