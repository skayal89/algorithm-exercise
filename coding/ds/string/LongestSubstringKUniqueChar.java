package coding.ds.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKUniqueChar {

    void kUnique(String s, int k){
        int i=0,j=0;
        int max=-1, maxi=0, maxj=0;
        char[] c=s.toCharArray();
        Map<Character, Integer> map=new HashMap<>();
        boolean isPossible=false;
        for(;j<c.length;j++){
            if(map.containsKey(c[j])){
                map.put(c[j],map.get(c[j])+1);
            }
            else{
                while(map.size()>=k && i<j){
                    int v=map.get(c[i]);
                    if(v>1){
                        map.put(c[i],v-1);
                    }
                    else {
                        map.remove(c[i]);
                    }
                    i++;
                }
                map.put(c[j],1);
            }
            System.out.println(map);
            if(map.size()==k){
                isPossible=true;
            }
            if(max<j-i+1){
                max=j-i+1;
                maxi=i;
                maxj=j;
            }
        }
        if(!isPossible) {
            System.err.println("Not Possible");
            return;
        }
        System.out.println(s.substring(maxi,maxj+1));
    }

    public static void main(String[] args) {
        new LongestSubstringKUniqueChar().kUnique("aabbc",3);
    }
}
