package coding.ds.array;

import java.util.Arrays;

public class QuickSort {
    static void qsort(int a[]){
        sort(a,0,a.length-1);
    }

    static void sort(int a[], int low, int high){
        if(low<high){
            int p= partition(a, low, high); System.out.println(p+" "+Arrays.toString(a));
            sort(a,low,p-1);
            sort(a,p+1,high);
        }
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
        qsort(a);
        System.out.println(Arrays.toString(a));
    }
}
