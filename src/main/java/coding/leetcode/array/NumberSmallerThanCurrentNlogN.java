package coding.leetcode.array;

import java.util.Arrays;

public class NumberSmallerThanCurrentNlogN {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Entry[] e = createEntry(nums);
        Arrays.sort(e);
        return buildResult(e);
    }

    private Entry[] createEntry(int a[]){
        Entry[] e = new Entry[a.length];
        for(int i=0;i<a.length;i++){
            e[i] = new Entry(a[i],i);
        }
        return e;
    }

    private int[] buildResult(Entry[] e){
        int r[] = new int[e.length];
        int prev = -1;
        for(int i=0;i<e.length;i++){
            if(isSameElement(e,i)){
                r[e[i].index]=prev;
            }
            else{
                r[e[i].index] = i;
                prev = i;
            }
        }
        return r;
    }

    private boolean isSameElement(Entry[] e, int i){
        if(e == null || i <= 0 || i >= e.length)  return false;
        return e[i].num == e[i-1].num;
    }

    public class Entry implements Comparable<Entry>{
        int num, index;

        Entry(int n, int i){
            num=n;
            index=i;
        }

        public int compareTo(Entry e){
            return this.num-e.num;
        }
    }
}