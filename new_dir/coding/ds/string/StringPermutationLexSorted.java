package coding.ds.string;

/*
 * Generate all permutation of given string in lexicographically
 * sorted order. Duplicate characters may be present in the string.
 *
 * Tushar Roy Video - String permutation
 */
public class StringPermutationLexSorted {

    void lexSortedPermutation(String s){
        int hash[]=new int[26];
        for(int i=0;i<s.length();i++){
            hash[(s.charAt(i)-'a')]++;
        }

        char[] res=new char[s.length()];
        util(hash,res,0);
    }

    void util(int hash[], char[] res, int i){
        if(i==res.length){
            print(res);
            return;
        }
        for (int j = 0; j < hash.length; j++) {
            if(hash[j]>0){
                hash[j]--;
                res[i]=(char)(j+'a');
                util(hash, res, i+1);
                hash[j]++;
            }
        }
    }

    void print(char[] res){
        System.out.println(String.valueOf(res));
    }

    public static void main(String[] args) {
        new StringPermutationLexSorted().lexSortedPermutation("aabc");
        new StringPermutationLexSorted().lexSortedPermutation("babbac");
    }
}
