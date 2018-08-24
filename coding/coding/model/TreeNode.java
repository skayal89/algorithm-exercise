package coding.coding.model;

public class TreeNode {
    public int data;
    public TreeNode left, right;

    public TreeNode(int data){
        this.data=data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
