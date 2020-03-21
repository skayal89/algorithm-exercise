package coding.ds.array.binarysearch;

public class MinValueInRotatedArray {
    int findMin(int a[]){
        return findMinUtil(a,0,a.length-1);
    }

    int findMinUtil(int a[], int low, int high){
        if(a[low]<=a[high])   return low;
        if(low<high){
            int mid=(low+high)/2;
            if((mid==low || a[mid-1]>a[mid]) && (mid==high || a[mid+1]>a[mid]))   return mid;
            else if(mid>low && a[low]>a[mid])    return findMinUtil(a,low,mid-1);
            return  findMinUtil(a,mid+1,high);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinValueInRotatedArray().findMin(new int[]{5,6,7,9,2,4}));
    }
}
