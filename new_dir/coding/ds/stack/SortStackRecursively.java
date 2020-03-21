package coding.ds.stack;

import java.util.Stack;

/*
    https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
    time - O(n^2), space - O(n)
 */
public class SortStackRecursively {
    void sort(Stack<Integer> s){
        if(s.isEmpty()) return;
        int x=s.pop();
        sort(s);
        insertAtSortedPostion(s,x);
    }

    private void insertAtSortedPostion(Stack<Integer> s, int x) {
        if(s.isEmpty() || x>s.peek()){
            s.push(x);
            return;
        }
        int p=s.pop();
        insertAtSortedPostion(s,x);
        s.push(p);
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        System.out.println(stack);
        new SortStackRecursively().sort(stack);
        System.out.println(stack);
    }
}
