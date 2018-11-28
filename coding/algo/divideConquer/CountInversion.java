package coding.algo.divideConquer;

import java.util.Arrays;

public class CountInversion {
    int mergeSort(int a[], int l, int h){
        if(l<h){
            int mid=(l+h)/2;
            int c1=mergeSort(a,l,mid);
            int c2=mergeSort(a,mid+1,h);
            int c=merge(a,l,mid,h);
            return c+c1+c2;
        }
        return 0;
    }

    int merge(int a[], int low, int mid, int high){
        int inv_count=0;
        int temp[]=new int[high-low+1];
        int i=low, j=mid+1,k=0;

        while (i<=mid && j<=high){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }
            else{
                inv_count+=(mid-i+1);
                temp[k++]=a[j++];
            }
        }

        while (i<=mid){
            temp[k++]=a[i++];
        }
        while (j<=high){
            temp[k++]=a[j++];
        }

        for (int l = low, m=0; l <= high; l++,m++) {
            a[l]=temp[m];
        }
        return inv_count;
    }

    int mergeSort(int a[]){
        int count = mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        System.out.println("Count = "+count);
        return count;
    }

    public static void main(String[] args) {
        int a[]=new int[]{2,4,1,3,5};
        new CountInversion().mergeSort(new int[]{8,2,9,6,1,10,11});
    }
}
