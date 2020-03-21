package coding.ds.liknedlist;

public class BinaryTreeToDLL {

    static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left=right=null;
        }

        @Override
        public String toString() {
            return data+" ";
        }
    }

    // https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
    Node head; // head must be a class variable
    Node toDLL(Node root){
        head=null;
        convertToDLL(root);
        return head;
    }

    void convertToDLL(Node root){
        if(root==null)  return;
        convertToDLL(root.right);
        root.right=head;
        if(head!=null){
            head.left=root;
        }
        head=root;
        convertToDLL(root.left);
    }

    // we should not define root resultant tree as a class variable
    // otherwise it will be shifted to last node
    // https://www.geeksforgeeks.org/in-place-conversion-of-sorted-dll-to-balanced-bst/
    Node toBT(){
        int n=count(head);
        System.out.println("length:"+n);
        return convertToBT(n);
    }

    Node convertToBT(int n){
        if(head==null || n<1)   return null;
        Node left=convertToBT(n/2); // it's considering mid-1 as left list where mid=ceil(n/2)
        Node root=head;
        root.left=left;
        head=head.right;
        root.right=convertToBT(n-n/2-1);
        return root;
    }

    int count(Node head){
        if(head==null)  return 0;
        int n=0;
        Node p=head;
        while (p!=null){
            n++;
            p=p.right;
        }
        return n;
    }

    void inorder(Node root){
        if (root==null) return;
        inorder(root.left);
        System.out.print(root);
        inorder(root.right);
    }

    public static void main(String[] args) {
        /* Constructing below tree
               5
             /   \
            3     6
           / \     \
          1   4     8
         / \       / \
        0   2     7   9  */
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(8);
        root.left.left.left = new Node(0);
        root.left.left.right = new Node(2);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(9);

        BinaryTreeToDLL obj=new BinaryTreeToDLL();
        Node list=obj.toDLL(root);
        Node q=list;
        while (q!=null){
            System.out.print(q);
            q=q.right;
        }
        System.out.println();

        Node tree=obj.toBT();
        System.out.println(tree);
        obj.inorder(tree);
    }
}
