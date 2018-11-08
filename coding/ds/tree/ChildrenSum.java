package coding.ds.tree;

import coding.coding.model.TreeNode;

public class ChildrenSum {
    static TreeNode convert(TreeNode t){
        if(t==null || (t.left==null && t.right==null)) return t;
        TreeNode l=convert(t.left);
        TreeNode r=convert(t.right);
        int lv = l==null ? 0 : l.data;
        int rv = r==null ? 0 : r.data;
        if(lv+rv>=t.data){
            t.data=l.data+r.data;
        }
        else{
            if(l!=null && r!=null){
                t.left= update(l,t.data-(l.data+r.data));
            }
            else if(l==null){
                t.right= update(r,t.data-r.data);
            }
            else t.left= update(l,t.data-l.data);
        }
        return t;
    }

    static TreeNode update(TreeNode t, int value){
        if(t==null) return t;
        t.data += value;
        if(t.left!=null)
            t.left= update(t.left,value);
        else t.right=update(t.right,value);
        return t;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(50);
        t.left=new TreeNode(7);
        t.right=new TreeNode(2);
        t.left.left=new TreeNode(3);
        t.left.right=new TreeNode(5);
        t.right.left=new TreeNode(1);
        t.right.right=new TreeNode(30);

//        TreeNode t=new TreeNode(30);
//        t.left=new TreeNode(20);
//        t.left.left=new TreeNode(15);

        InorderUsingStack.inorder3(convert(t));
    }
}
