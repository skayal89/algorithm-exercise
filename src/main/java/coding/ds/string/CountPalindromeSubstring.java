package coding.ds.string;

import java.util.HashSet;

public class CountPalindromeSubstring {
    static int count(String s){
        int low, high;
        int n=s.length();
        int c=0;
        HashSet<String> set=new HashSet<>();

        for (int i = 0; i < n; i++) {
            // Even palindrome
            low=i;
            high=i+1;
            while (low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                if(high-low+1>1){
                    c++;
                    set.add(s.substring(low,high+1));
                }
                low--;
                high++;
            }

            // Odd palindrome
            low=i-1;
            high=i+1;
            while (low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                if(high-low+1>1){
                    c++;
                    set.add(s.substring(low,high+1));
                }
                low--;
                high++;
            }
        }
        System.out.println(set);
        return c;
    }

    static int countDistinctSubstring(String s){
        int low, high;
        int n=s.length();
        HashSet<String> set=new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(s.substring(i,i+1)); // single char is always a palindrome

            low=i;
            high=i+1;
            while (low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                set.add(s.substring(low,high+1));
                low--;
                high++;
            }

            low=i-1;
            high=i+1;
            while (low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                set.add(s.substring(low,high+1));
                low--;
                high++;
            }
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(count("abaab"));
        System.out.println(count("abbaeae"));
        System.out.println(countDistinctSubstring("abaaa"));
        System.out.println(countDistinctSubstring("geek"));
    }
}
