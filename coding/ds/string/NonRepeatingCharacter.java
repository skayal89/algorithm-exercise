package coding.ds.string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {

    static char firstNonRepeatingChar(String s){
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int v=map.get(c);
                map.put(c,v+1);
            }
            else {
                map.put(c,1);
            }
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }

        return '\0';
    }

    static char kthNonRepeatingChar(String s, int k){
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int v=map.get(c);
                map.put(c,v+1);
            }
            else {
                map.put(c,1);
            }
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                count++;
            }
            if(count==k){
                return entry.getKey();
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String s="geeksforgeeks";
        System.out.println(firstNonRepeatingChar(s));
        System.out.println(kthNonRepeatingChar(s,3));
        System.out.println(lengthOfLongestSubstringWithUniqueChar("geeksforgeeks"));
    }
}
