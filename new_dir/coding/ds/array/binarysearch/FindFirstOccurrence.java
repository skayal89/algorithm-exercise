package coding.ds.array.binarysearch;

import java.util.Arrays;

public class FindFirstOccurrence {
    int first(int t[], int x){
        return binarySearch(t, x, 0, t.length-1);
    }

    int binarySearch(int t[], int x, int low, int high){
        if(low==high && t[low]==x){
            return low;
        }
        if(low<high){
            int mid=(low+high)/2;
            if(t[mid]==x && (mid==low || (mid>low && t[mid-1]!=x))) return mid;
            if(mid>low && t[mid-1]>=x)  return binarySearch(t, x, low, mid-1);
            return binarySearch(t, x, mid+1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        int a1[] = new int[]{2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));
        System.out.println(new FindFirstOccurrence().first(a1,3));
    }
}
