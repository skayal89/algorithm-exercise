package coding.ds.array.sort;


import java.util.Arrays;

public class MergeSort {
    public void sort(int a[]){
        mergeSort(a,0,a.length-1);
    }

    private void mergeSort(int a[], int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    private void merge(int a[], int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int k = 0;
        int n = a.length;
        int temp[] = new int[high-low+1];

        while(i < n && j<n && i<=mid && j<=high){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }
            else {
                temp[k++] = a[j++];
            }
        }
        while(i<n && i<=mid){
            temp[k++] = a[i++];
        }
        while(j<n && j<=high){
            temp[k++] = a[j++];
        }

        k=0;
        for(int p=low;p<=high;p++){
            a[p] = temp[k++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int a[] = new int[]{4,1,9,7,5,2,10};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{3,3,3,3,3,3};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{2,4,7,9,11};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{11,9,6,3,1};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{3};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
