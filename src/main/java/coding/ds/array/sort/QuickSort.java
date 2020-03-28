package coding.ds.array.sort;

import java.util.Arrays;

public class QuickSort {

    public void sort(int a[]){
        qsort(a,0,a.length-1);
    }

    private void qsort(int a[], int low, int high){
        if(low < high){
            int p = partition(a,low,high);
            qsort(a,low,p-1);
            qsort(a,p+1,high);
        }
    }

    private int partition(int a[], int low, int high){
        int pivot = a[high];
        int l = low;
        for(int j = low; j < high; j++){
            if(a[j] < pivot){
                int t = a[l];
                a[l] = a[j];
                a[j] = t;
                l++;
            }
        }
        int t = a[l];
        a[l] = a[high];
        a[high] = t;
        return l;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int a[] = new int[]{4,1,9,7,5,2,10};
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{3,3,3,3,3,3};
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{2,4,7,9,11};
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{11,9,6,3,1};
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{3};
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{};
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
