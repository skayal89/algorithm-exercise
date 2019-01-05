package coding.ds.string;

import coding.util.ArrayUtil;

public class KMPPatternSearching {

    static int[] buildPrefixTable(String s){
        int n=s.length();
        int p[]=new int[n];
        p[0]=0;
        int j=0,i=1;
        while(i<n){
            if(j==i)    j=0;
            if(s.charAt(i)==s.charAt(j)){
                p[i++]=j+1;
                j++;
            }
            else{
                if(j>0){
                    j=p[j-1];
                }
                else{
                    p[i++]=0;
                }
            }
        }
        return p;
    }

    static int searchPattern(String s, String pattern){
        int prefixTable[]=buildPrefixTable(pattern);
        int n=s.length(), m=pattern.length();
        int i=0,j=0;
        while(i<n){
            if(j<m && s.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            else if(j<m && s.charAt(i)!=pattern.charAt(j)){
                if(j>0){
                    j=prefixTable[j-1];
                }
                else i++;
            }
            if(j==m){
                return i-j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[]=buildPrefixTable("abcdabcy");
        ArrayUtil.print(a);

        System.out.println(searchPattern("abcxabcdabxabcdabcdabcy","abcdabcy"));
    }
}
