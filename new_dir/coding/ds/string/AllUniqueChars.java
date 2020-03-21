package coding.ds.string;

import java.util.Arrays;
import java.util.HashSet;

public class AllUniqueChars {

    public static void main(String ar[]){
        String s[]=new String[]{"abcdefgh","a","ab","aaa","abbcabncd","qwertyuiop"};
        for (String st :
                s) {
            System.out.println(st+" "+f3(st));
        }
    }

    public static boolean f1(String s){
        HashSet<Character> set=new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                return false;
            }
            else{
                set.add(s.charAt(i));
            }
        }
        return true;
    }

    public static boolean f2(String s){
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        for (int i = 1; i < ch.length; i++) {
            if(ch[i-1]==ch[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean f3(String s){
        int count[]=new int[128];
        for (int i = 0; i < s.length(); i++) {
            int c=(int)s.charAt(i);
            if(count[c]==1){
                return false;
            }
            else {
                count[c]=1;
            }
        }
        return true;
    }
}
