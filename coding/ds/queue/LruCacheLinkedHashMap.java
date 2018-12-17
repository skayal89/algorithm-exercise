package coding.ds.queue;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCacheLinkedHashMap<S,T> extends LinkedHashMap<S, T> {

    int capacity;

    LruCacheLinkedHashMap(int capacity){
        super(capacity,0.75f,true); // true for access-order (LRU), false for insertion-order
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<S, T> eldest) {
        return this.size() > capacity; //must override it if used in a fixed cache
    }

    public static void main(String[] args) {
        LruCacheLinkedHashMap<Integer, String> cache=new LruCacheLinkedHashMap<Integer, String>(3);
        cache.put(10,"Hi");
        cache.put(9,"Hello");
        cache.put(11,"bye");
        System.out.println(cache);
        cache.get(10);
        cache.put(8,"Ohh");
        System.out.println(cache);
        cache.put(17,"Me");
        System.out.println(cache);
    }
}
