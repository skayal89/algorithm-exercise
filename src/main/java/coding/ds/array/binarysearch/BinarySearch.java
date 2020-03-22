package coding.ds.array.binarysearch;

public class BinarySearch {

    public int recrsive(int a[], int low, int high, int target){
        if(!isValidParam(a, low, high)) return -1;
        if(low == high && a[low]==target)   return low;
        if(low < high){
            int mid = (low+high)/2;
            if(a[mid]==target)  return mid;
            else if(a[mid]>target)   return recrsive(a,low,mid-1,target);
            else return recrsive(a,mid+1,high,target);
        }
        return -1;
    }

    public int iterative(int a[], int target){
        if(a == null)   return -1;
        int low = 0, high = a.length-1;
        while (low <= high){
            if(low == high && a[low]==target)   return low;
            int mid = (low+high)/2;
            if(a[mid]==target)  return mid;
            else if(a[mid]>target)   high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    private boolean isValidParam(int a[], int low, int high){
        return a != null && low >= 0 && low < a.length && high >= 0 && high < a.length;
    }
}
