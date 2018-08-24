package coding.ds.liknedlist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class LinkedHashMap<K,V> {

    private Entry<K,V> first, last;
    private int size, capacity;
    private Entry<K,V> entries[];

    @SuppressWarnings("unchecked")
    public LinkedHashMap(int capacity) {
        this.capacity=capacity;
        this.entries = (Entry<K,V>[]) Array.newInstance(Entry.class,capacity);
        size=0;
    }

    static class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;
        Entry<K,V> before,after;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "["+key+","+value+"] ";
        }

        @Override
        public boolean equals(Object obj) {
            return key==((Integer) obj);
        }
    }

    public int size(){
        return size;
    }

    public void put(K key, V value){
        Entry<K,V> entry=new Entry<K,V>(key,value);
        int index=key.hashCode()%capacity;
        Entry<K,V> e=entries[index];

        if(first==null){
            first=entry;
            entry.before=null;
            entry.after=null;
            last=entry;
        }
        else {
            entry.before=last;
            last.after=entry;
            entry.after=null;
            last=last.after;
        }

        if(e!=null){
            entry.next=e;
        }
        entries[index]=entry;
        size++;
    }

    public V get(K key){
        int index=key.hashCode()%capacity;
        Entry<K,V> e=entries[index];
        System.out.println(index+" "+e);
        while(e!=null){
            if(e.equals(key)){
                return e.value;
            }
            e=e.next;
        }
        return null;
    }

    public Entry<K, V> getFirst() {
        return first;
    }

    public Entry<K, V> getLast() {
        return last;
    }

    public Entry<K,V> peek(){
        return getFirst();
    }

    public void print(){
        Entry<K,V> p=first;
        while(p!=null){
            System.out.print("["+p.key+","+p.value+"] ");
            p=p.after;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer, Integer>(3);
        map.put(10,5);
        map.put(13,15);
        map.put(15,7);
        map.put(20,3);
        map.put(12,64);
        map.print();

        while(true){
            System.out.println("Value:"+map.get(new Scanner(System.in).nextInt()));
        }
    }
}
