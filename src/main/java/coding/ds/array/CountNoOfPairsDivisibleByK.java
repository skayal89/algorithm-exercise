package coding.ds.array;

import java.util.HashMap;
import java.util.Map;

public class CountNoOfPairsDivisibleByK {
    static int count(int a[], int k){
        int n = a.length;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>(){
            @Override
            public Integer get(Object key) {
                if(!containsKey(key)) return 0;
                return super.get(key);
            }
        };

        for(int i=0;i<n;i++){
            int r=a[i]%k;
            map.put(r,map.get(r)+1);
        }
        System.out.println(map);

        int elementCount=0;
        for (int i = 0; i < k; i++) {
            int x=map.get(i);
            if(i==0 || 2*i == k){
                elementCount+=(x*(x-1))/2;
            }
            else{
                elementCount+= (x*map.get(k-i));
                map.remove(i);
                map.remove(k-i);
            }
        }
        return elementCount;
    }

    public static void main(String[] args) {
        int a[]=new int[]{92, 75, 65, 48, 45, 35};
        System.out.println(count(a,10));
    }
}
