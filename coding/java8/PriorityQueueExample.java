package coding.java8;

import coding.ds.string.RemoveDuplicates;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Java 8 way to define Comparator
        Queue<Key> priorityQueue=new PriorityQueue<>((k1, k2)->k2.freq-k1.freq);

        priorityQueue.add(new Key('a',3));
        priorityQueue.add(new Key('b',1));
        priorityQueue.add(new Key('c',1));
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }

    @ToString
    @AllArgsConstructor
    static class Key{
        char c;
        int freq;
    }
}
