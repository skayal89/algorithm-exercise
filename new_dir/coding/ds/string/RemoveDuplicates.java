package coding.ds.string;

import lombok.ToString;

import java.util.*;

public class RemoveDuplicates {

    static String removeDuplicates(String s){
        Set<Character> set=new LinkedHashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        set.forEach(System.out::print);
        System.out.println();

        StringBuilder sb=new StringBuilder();
        for(Character c : set){
            sb.append(c);
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        System.out.println(removeDuplicates("geeksforgeeks"));
        System.out.println(removeDuplicates("HappyNewYear"));
        System.out.println(removeDuplicates("azxxzy"));

    }
}
