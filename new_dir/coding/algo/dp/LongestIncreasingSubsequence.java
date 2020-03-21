package coding.algo.dp;

import java.util.Arrays;

// O(nlogn) - Review Tushar Roy video
public class LongestIncreasingSubsequence {

    int lengthOfLIS(int a[], int n){
        int t[]=new int[n]; // holds the indices of a[]
        int p[]=new int[n]; // parent array
        int len=0; // last index of LIS till now

        t[0]=0; // initialize with 0th index of a[]
        Arrays.fill(p,-1);

        for (int i = 1; i < n; i++) {
            if(a[i]>a[t[len]]){
                t[len+1]=i;
                p[len+1]=t[len];
                len++;
            }
            else {
                if(a[i]<a[t[0]]){
                    t[0]=i;
                }
                else {
                    int j=binarySearchCeil(a, t, len+1, a[i]);
                    t[j]=i; // binarySearchCeil will always return a valid index because we have already checked in
                    p[j]=t[j-1]; // prev condition that the target is not lesser the a[t[0]] and not greater than a[t[len]]
                }
            }
        }
        System.out.println("Table: "+Arrays.toString(t));
        System.out.println("Parent: "+Arrays.toString(p));

        System.out.println("Longest Increasing subsequence:"); // print the sequence
        int k=len;
        System.out.print(a[t[len]]+" ");
        while (p[k]>=0){
            System.out.print(a[p[k]]+" ");
            k--;
        }
        System.out.println();

        return len+1;
    }

    private int binarySearchCeil(int input[], int table[], int tableLength, int target){ // all values of input[] is distinct
        return binarySearchCeilUtil(input, table, target, 0, tableLength);
    }

    private int binarySearchCeilUtil(int input[], int table[], int target, int low, int high){
        if(low==high){
            if(input[table[low]]>target){
                return low;
            }
        }
        if (low<high){
            int mid=(low + high)/2;
            if(input[table[mid]]>target && (mid==low || (mid>low && input[table[mid-1]]<target)))    return mid;
            if(input[table[mid]]<target)    return binarySearchCeilUtil(input, table, target, mid+1, high);
            return binarySearchCeilUtil(input, table, target, low, mid-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[]=new int[]{2,5,9,15,22,55};
        int t[]=new int[]{1,2,3,5};
        System.out.println(new LongestIncreasingSubsequence().binarySearchCeil(a,t, 4, 16));

        int b[]=new int[]{3,4,-1,5,8,2,3,12,7,9,10};
        int b1[]=new int[]{3,1,2,8,5,9,7,15,30};
        int b2[]=new int[]{1,2,3,4,5,6,7};
        int b3[]=new int[]{5,4,3,2,1};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(b, b.length));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(b1, b1.length));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(b2, b2.length));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(b3, b3.length));
    }
}
