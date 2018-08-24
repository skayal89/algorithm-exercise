package coding.ds.stack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StackUsingMinHeap {

    PriorityQueue<Util> queue;
    int order;

    StackUsingMinHeap(int size){
        queue=new PriorityQueue<Util>(size, new Comparator<Util>() {
            public int compare(Util o1, Util o2) {
                return o2.order-o1.order;
            }
        });
        order=0;
    }

    public static void main(String ar[]){
        StackUsingMinHeap s=new StackUsingMinHeap(5);
        s.push(10);
        s.push(13);
        System.out.println(s.peek());
        s.push(9);
        System.out.println(s.pop());
        s.push(11);
        System.out.println(s.peek());
    }

    public void push(int x){
        queue.add(new Util(x,order++));
    }

    public int pop(){
        if(queue.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return queue.poll().element;
    }

    public boolean empty(){
        return queue.isEmpty();
    }

    public int peek(){
        if(queue.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return queue.peek().element;
    }

    static class Util{
        int element, order;

        Util(int e, int o){
            element=e;
            order=o;
        }

        @Override
        public String toString() {
            return "Util{" +
                    "element=" + element +
                    ", order=" + order +
                    '}';
        }
    }
}
