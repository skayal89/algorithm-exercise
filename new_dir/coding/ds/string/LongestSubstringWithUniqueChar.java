package coding.ds.string;

import java.util.HashSet;

public class LongestSubstringWithUniqueChar {

    static int lengthOfLongestSubstringWithUniqueChar(String s){
        HashSet<Character> set=new HashSet<>();
        int maxLength=0, i=0, j=0, n=s.length();

        while(j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                if(j-i+1>maxLength){
                    maxLength=j-i+1;
                }
                j++;
            }
            else {
                while(i<j && set.contains(s.charAt(i))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringWithUniqueChar("geeksforgeeks"));
    }
}
