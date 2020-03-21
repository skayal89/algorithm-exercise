package coding.algo.dp;

import coding.util.ArrayUtil;

public class WordBreak {

    // Time - O(n^3), Space - O(n), n - size of str
    static boolean wordBreak(String str)
    {
        int size = str.length();
        if (size == 0)   return true;

        // Create the DP table to store results of subroblems. The value wb[i]
        // will be true if str[0..i-1] can be segmented into dictionary words,
        // otherwise false.
        boolean wb[]=new boolean[size+1];
        //memset(wb, 0, sizeof(wb)); // Initialize all values as false.

        for (int i=1; i<=size; i++)
        {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            System.out.println("OuterLoop: "+str.substring(0, i));
            if (wb[i] == false && dictionaryContains( str.substring(0, i) ))
                wb[i] = true;

            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            // wb[i]=true means substring(0,i) can be segmented into valid words.
            if (wb[i] == true)
            {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i+1; j <= size; j++)
                {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // substring starting from index 'i' and length 'j-i'
                    // wb[j] is true means substring(0,j) can be segmented into valid words
                    // because wb[i] and wb[j] both are true.
                    System.out.println("InnerLoop: ["+i+","+j+"] ->"+str.substring(i, j));
                    if (wb[j] == false && dictionaryContains( str.substring(i, j) ))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
            ArrayUtil.print(wb);
        }

        ArrayUtil.print(wb);

        // If we have tried all prefixes and none of them worked
        return false;
    }

    // can be optimized using Trie
    static boolean dictionaryContains(String word)
    {
//        String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
//                "icecream","and","go","i","like","ice","cream"};
        String dictionary[] = {"i","a","am","ace"};
        int size = dictionary.length;
        for (int i = 0; i < size; i++)
            if (dictionary[i].compareTo(word) == 0)
                return true;
        return false;
    }

    // Tushar Roy, Space - O(n^2), Time - O(n^3)
    static boolean wordBreak2(String s){
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        for (int l=1;l<=n;l++){
            for (int i=0;i<n-l+1;i++){
                int k=i+l-1;
                for (int j = i; j < k; j++) {
                    if(dp[i][j] && dp[j+1][k]){
                        dp[i][k]=true;
                        break;
                    }
                }
                if(dp[i][k]==false){
                    dp[i][k]=dictionaryContains(s.substring(i,k+1));
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("iamaco"));
        System.out.println(wordBreak2("iamaco"));
    }
}
