package coding.coding.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data){
        this.data=data;
        this.next=null;
    }


}
