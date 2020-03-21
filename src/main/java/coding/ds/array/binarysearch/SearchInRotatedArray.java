package coding.ds.array.binarysearch;

public class SearchInRotatedArray {
    static int search(int a[], int t){
        return searchUtil(a,0,a.length-1,t);
    }

    static int searchUtil(int a[], int low, int high, int t){
        if(low==high && a[low]==t)  return low;
        if(low<high){
            int mid=(low+high)/2;
            if(a[mid]==t)   return mid;
            else if(a[low]<=a[mid])  {
                if(a[low]<=t && a[mid]>=t)
                    return searchUtil(a,low,mid-1,t);
                else
                    return searchUtil(a, mid+1,high,t);
            }
            else if(a[mid]<=a[high]){
                if(a[mid]<=t && a[high]>=t) return searchUtil(a,mid+1,high,t);
                else return searchUtil(a,low,mid-1,t);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{8,9,2,4,6,7},4));
    }
}
