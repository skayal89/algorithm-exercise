package coding.ds.array;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInWindow {
    // k is window size
    void countDistinctElements(int a[], int n, int k){
        Map<Integer,Integer> map=new HashMap<>();
        int i=0, j=0;
        for(;j<k;j++){
            map.merge(a[j],1, (x,y) -> x+y); // x = oldValue, y = 1 (newValue) -> increment the count by 1
        }
        j=k-1;
        System.out.println(map.size());
        while (i<n && j<n){
            map.merge(a[i++], 1, (x,y) -> x==1 ? null : x-y); // element will be removed if count becomes 0, i.e if bi-function returns null then key will be removed
            if(j<n-1) {
                map.merge(a[++j], 1, (x, y) -> x + y);
            }
            System.out.println(map.size());
            if (j==n-1) break;
        }
    }

    public static void main(String[] args) {
        int a[]=new int[]{1,2,1,3,4,2,3};
        new CountDistinctElementsInWindow().countDistinctElements(a, a.length, 4);
    }
}
