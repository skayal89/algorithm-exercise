package coding.ds.string;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static void main(String ar[]){
        String test="abcd";
        String s[]=new String[]{"bcda","dbca","abbc","aaaa","abcdd","dcba"};
        for (String st :
                s) {
            System.out.println(st+" "+f2(test,st));
        }
    }

    public static boolean f1(String s, String t){
        if(s==null && t==null)  return true;
        if(s==null || t==null)  return false;
        if(s.length()!=t.length())  return false;
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c=t.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int x=map.get(c);
                if(x==1)    map.remove(c);
                else
                    map.put(c,map.get(c)-1);
            }
            else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static boolean f2(String s, String t){
        if(s==null && t==null)  return true;
        if(s==null || t==null)  return false;
        if(s.length()!=t.length())  return false;
        char[] sc=s.toCharArray();
        char[] tc=t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i < s.length(); i++) {
            if(sc[i]!=tc[i])    return false;
        }
        return true;
    }
}
