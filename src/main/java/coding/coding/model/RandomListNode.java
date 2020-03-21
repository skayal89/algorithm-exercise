package coding.coding.model;

import lombok.ToString;

@ToString
public class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) { this.label = x; }
}
