package coding.ds.array.binarysearch;

/*
 * https://youtu.be/5qBTq6X7ui4
 * https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 * https://algorithmsandme.com/find-kth-smallest-element-in-two-sorted-arrays/
 *
 * K-th Element of Two Sorted Arrays
 */
public class KthSmallestTwoSortedArray {

    // O(log k)
    static int kthSmallestLogK(int a[], int alow, int ahigh, int b[], int blow, int bhigh, int k){
        int m = ahigh-alow+1;
        int n = bhigh-blow+1;
        if(k > m+n || k<1)  return -1;
        if(m > n)   return kthSmallestLogK(b, blow, bhigh, a, alow, ahigh, k); // make sure array a is the smallest
        if(m==0)    return b[k-1+blow];
        if(k==1)    return Math.min(a[alow],b[blow]);

        int i = Math.min(m, k/2) + alow; // we have taken min to make sure i and j is a valid index
        int j = Math.min(n, k/2) + blow; // actually we want on k/2

        // we are taking min with m or n. so it can contain the size which is not a valid index
        if(a[i-1]<b[j-1]){
            return kthSmallestLogK(a, i, ahigh, b, blow, bhigh, k-(i-alow));
        }
        else {
            return kthSmallestLogK(a, alow, ahigh, b, j, bhigh, k-(j-blow));
        }
    }

    static int kthLogK(int a[], int b[], int k){
        return kthSmallestLogK(a, 0, a.length-1, b, 0, b.length-1, k);
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{2, 3, 6, 7, 9};
        int arr2[] = new int[]{1, 4, 8, 10};
        int k = 7;

        System.out.println(kthLogK(arr1,arr2,k));
    }
}
