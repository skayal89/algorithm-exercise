package coding.ds.tree;

public class AvlTree {
    static class Node{
        int data;
        int height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.height=1;
            left=right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", height=" + height +
                    '}';
        }
    }

    Node insert(Node root, int key){
        if(root==null){
            return new Node(key);
        }
        if(key<root.data){
            root.left=insert(root.left,key);
        }
        else if(key>root.data){
            root.right=insert(root.right,key);
        }
        // above insertion part remains same as standard BST insertion
        root.height=1+Math.max(h(root.left),h(root.right));
        int bf=h(root.left)-h(root.right);
        if(bf>1){
            if(h(root.left.left)>=h(root.left.right)){ // LL case
                root=rotateRight(root);
            }
            else { // LR case
                root.left=rotateLeft(root.left);
                root=rotateRight(root);
            }
        }
        if(bf<-1){
            if(h(root.right.left)<=h(root.right.right)){ // RR case
                root=rotateLeft(root);
            }
            else { // RL case
                root.right=rotateRight(root.right);
                root=rotateLeft(root);
            }
        }
        return root;
    }

    Node delete(Node root, int key){ // same as insertion
        if(root==null)  return null;
        if(key<root.data){
            root.left=delete(root.left,key);
        }
        else if(key>root.data){
            root.right=delete(root.right, key);
        }
        else {
            if(root.left==null){
                root=root.right;
            }
            else if(root.right==null){
                root=root.left;
            }
            else {
                Node s= minValue(root.right);
                root.data = s.data;
                root.right = delete(root.right, s.data);
            }

        }
        if(root==null)  return root; // in case of leaf node, root will become null
        root.height=1+Math.max(h(root.left),h(root.right));
        int bf=h(root.left)-h(root.right);
        if(bf>1){
            if(h(root.left.left)>=h(root.left.right)){
                root=rotateRight(root);
            }
            else {
                root.left=rotateLeft(root.left);
                root=rotateRight(root);
            }
        }
        if(bf<-1){
            if(h(root.right.left)<=h(root.right.right)){
                root=rotateLeft(root);
            }
            else {
                root.right=rotateRight(root.right);
                root=rotateLeft(root);
            }
        }
        return root;
    }

    Node minValue(Node root){
        if(root == null)    return null;
        Node t=root;
        while (t.left!=null){
            t=t.left;
        }
        return t;
    }

    Node rotateRight(Node root){
        Node newRoot=root.left;
        root.left=newRoot.right;
        newRoot.right=root;
        root.height=1+Math.max(h(root.left),h(root.right));
        newRoot.height=1+Math.max(h(newRoot.left),h(newRoot.right));
        return newRoot;
    }

    Node rotateLeft(Node root){
        Node newRoot=root.right;
        root.right=newRoot.left;
        newRoot.left=root;
        root.height=1+Math.max(h(root.left),h(root.right));
        newRoot.height=1+Math.max(h(newRoot.left),h(newRoot.right));
        return newRoot;
    }

    int h(Node root){
        if(root==null)  return 0;
        return root.height;
    }

    void preOrder(Node root){
        if(root!=null) {
            System.out.print(root + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        AvlTree tree = new AvlTree();

        Node t=null;
        /* Constructing tree given in the above figure */
        t = tree.insert(t, 10);
        t = tree.insert(t, 20);
        t = tree.insert(t, 30); //tree.preOrder(t);
        t = tree.insert(t, 40);
        t = tree.insert(t, 50);
        t = tree.insert(t, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(t);

        System.out.println("\nAfter Deletion:");
        tree.delete(t, 30);
        tree.preOrder(t);
    }


}
