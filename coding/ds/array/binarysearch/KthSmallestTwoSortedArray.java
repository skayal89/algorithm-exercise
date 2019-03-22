package coding.ds.array.binarysearch;

public class KthSmallestTwoSortedArray {

    static int kthSmallest(int a[], int alow, int ahigh, int b[], int blow, int bhigh, int k){
        int m = ahigh-alow+1;
        int n = bhigh-blow+1;
        if(k > m+n || k<1)  return -1;
        if(m > n)   return kthSmallest(b, blow, bhigh, a, alow, ahigh, k); // make sure array a is the smallest
        if(m==0)    return b[k-1+blow];
        if(k==1)    return Math.min(a[alow],b[blow]);

        int i = Math.min(m, k/2) + alow; // we have taken min to make sure i and j is a valid index
        int j = Math.min(n, k/2) + blow; // actually we want on k/2

        // we are taking min with m or n. so it can contain the size which is not a valid index
        if(a[i-1]<b[j-1]){
            return kthSmallest(a, i, ahigh, b, blow, bhigh, k-(i-alow));
        }
        else {
            return kthSmallest(a, alow, ahigh, b, j, bhigh, k-(j-blow));
        }
    }

    static int kth(int a[], int b[], int k){
        return kthSmallest(a, 0, a.length-1, b, 0, b.length-1, k);
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{2, 3, 6, 7, 9};
        int arr2[] = new int[]{1, 4, 8, 10};

        System.out.println(kth(arr1,arr2,9));
    }
}
