package coding.ds.stack;

import java.util.Stack;

/*
    https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
    time - O(n^2), space - O(n)
 */
public class ReverseStackRecursively {
    void reverse(Stack<Integer> s){
        if(s.isEmpty()) return;
        int x=s.pop();
        reverse(s);
        insertAtBottom(s,x);
    }

    private void insertAtBottom(Stack<Integer> s, int x) {
        if(s.isEmpty()){
            s.push(x);
            return;
        }
        int p=s.pop();
        insertAtBottom(s,x);
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
        new ReverseStackRecursively().reverse(stack);
        System.out.println(stack);
    }
}
