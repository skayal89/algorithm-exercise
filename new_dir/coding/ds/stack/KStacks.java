package coding.ds.stack;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class KStacks {

    int size;
    int[] data;
    int nextIndex[];
    int[] tops;
    int nextAvailable;
    int noOfStacks;

    KStacks(int size,int noOfStacks){
        this.size=size;
        this.noOfStacks=noOfStacks;
        data=new int[size];
        nextIndex=new int[size];
        tops=new int[noOfStacks];
        nextAvailable=0;

        for (int i = 0; i < size; i++) {
            nextIndex[i] = (i == size-1 ? -1 : i+1);
        }
        for (int i = 0; i < noOfStacks; i++) {
            tops[i]=-1;
        }
    }

    void push(int stackId, int element){
        if(nextAvailable==-1){
            throw new IndexOutOfBoundsException("Stack Full");
        }
        int temp=nextAvailable;
        data[nextAvailable]=element;
        nextAvailable=nextIndex[temp];
        nextIndex[temp]=tops[stackId];
        tops[stackId]=temp;
    }

    int pop(int stackId){
        if(tops[stackId]==-1){
            throw new NoSuchElementException("Stack "+stackId+" is empty");
        }
        int temp=tops[stackId];
        tops[stackId]=nextIndex[temp];
        nextIndex[temp]=nextAvailable;
        nextAvailable=temp;
        return data[temp];
    }

    int peek(int stackId){
        if(tops[stackId]==-1){
            throw new NoSuchElementException("Stack "+stackId+" is empty");
        }
        return data[tops[stackId]];
    }

    boolean isEmpty(int stackId){
        return tops[stackId]==-1;
    }

    boolean isFull(int stackId){
        return nextAvailable==-1;
    }

    public static void main(String[] args) {
        KStacks s=new KStacks(6,3);
        Scanner in=new Scanner(System.in);
        while(true){
            System.out.println("1. Push\n2. Pop\n3. Empty\n4. Full\n5. Peek\n(stackId, choice)");
            int stackId=in.nextInt();
            int choice=in.nextInt();
            switch (choice){
                case 1:
                    System.out.println("\nEnter Element:");
                    s.push(stackId,in.nextInt());
                    break;
                case 2:
                    System.out.println(stackId+": "+s.pop(stackId)+" popped");
                    break;
                case 3:
                    System.out.println(stackId+": "+s.isEmpty(stackId));
                    break;
                case 4:
                    System.out.println(stackId+": "+s.isFull(stackId));
                    break;
                case 5:
                    System.out.println(stackId+": "+s.peek(stackId));
                    break;
            }
        }
    }
}
