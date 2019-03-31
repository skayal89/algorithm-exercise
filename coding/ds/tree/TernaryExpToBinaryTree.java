package coding.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TernaryExpToBinaryTree {

    class Node
    {
        char data;
        Node left, right;

        public Node(char item)
        {
            data = item;
            left = null;
            right = null;
        }
    }

    static int i;
    Node convertExpression(char[] expression)
    {
        // Base case
        if (i >= expression.length)
            return null;

        // store current character of expression_string
        // [ 'a' to 'z']
        Node root = new Node(expression[i]);

        // Move ahead in str
        ++i;

        // if current character of ternary expression is '?'
        // then we add next character as a left child of
        // current node
        if (i < expression.length && expression[i]=='?') {
            i++;
            root.left = convertExpression(expression);
            i++;
            root.right = convertExpression(expression);
        }

        return root;
    }

    Node convert(char[] exp){
        i=0;
        return convertExpression(exp);
    }

    // function print tree
    public void inorder(Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }

    public void levelOrder(Node t){
        if(t!=null){
            Queue<Node> q=new LinkedList<Node>();
            q.add(t);
            while (!q.isEmpty()){
                int size=q.size();
                while(size-->0) {
                    Node temp = q.poll();
                    System.out.print(temp.data + " ");
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String args[])
    {
        String exp = "a?x?y:z:b";
        TernaryExpToBinaryTree tree = new TernaryExpToBinaryTree();
        char[] expression=exp.toCharArray();
        Node root = tree.convertExpression(expression);
        tree.inorder(root) ;
        System.out.println();
        tree.levelOrder(root); ;
    }
}
