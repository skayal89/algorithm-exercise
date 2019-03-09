package coding.ds.array;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
Method 4
 */
public class KthSmallestElementQSort {
    static int qsort(int a[], int k){
        return sort(a,0,a.length-1,k);
    }

    static int sort(int a[], int low, int high, int k){
        // If k is smaller than number of elements in array - without this check is also fine
        if(low<=high && k<=(high-low+1)){
            int p=partition(a, low, high);
            System.out.println(p+" "+Arrays.toString(a));
            if(p==k-1)  {
                System.out.println("k:"+a[p]);
                return a[p];
            }
            else if(p>k-1)
                return sort(a,low,p-1,k);
            else
                return sort(a,p+1,high,k);
        }
        return -1; // any invalid input can be returned
    }

    static int partition(int a[], int low, int high){
        int pivot=low;
        int l=low+1,h=high;
        while (l<=h){
            while(l<=h && a[l]<a[pivot]){
                l++;
            }
            while (h>=l && a[h]>=a[pivot]){
                h--;
            }
            if(l<=h) {
                int t = a[l];
                a[l] = a[h];
                a[h] = t;
            }
        }
        int t=a[pivot];
        a[pivot]=a[h];
        a[h]=t;
        return h;
    }

    public static void main(String[] args) {
        int a[]=new int[]{4,2,1,3,7,9,5,6,8};
        System.out.println(qsort(a,6));
        System.out.println(Arrays.toString(a));
    }
}
