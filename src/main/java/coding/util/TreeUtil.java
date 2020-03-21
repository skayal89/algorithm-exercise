package coding.util;

import coding.coding.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {

    public static TreeNode sample1(){
        TreeNode t=new TreeNode(10);
        t.left=new TreeNode(13);
        t.right=new TreeNode(50);
        t.left.left=new TreeNode(18);
        t.left.right=new TreeNode(20);
        t.left.left.left=new TreeNode(100);
        return t;
    }

    public static void inorder(TreeNode t){
        if(t!=null){
            inorder(t.left);
            System.out.print(t.data+" ");
            inorder(t.right);
        }
    }

    public static void levelOrder(TreeNode t){
        if(t!=null){
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(t);
            while (!q.isEmpty()){
                TreeNode temp=q.poll();
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
    }

    public static void printByLevel(TreeNode t){
        if(t!=null){
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(t);
            while (!q.isEmpty()){
                int count=q.size();
                while(!q.isEmpty() && count>0){
                    TreeNode temp=q.poll();
                    System.out.print(temp.data+" ");
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                    count--;
                }
                System.out.println();
            }
        }
    }

    public static int size(TreeNode t){
        if(t==null) return 0;
        return 1+size(t.left)+size(t.right);
    }
}
