package coding.ds.rmq;

import coding.algo.math.NextPowerOf2;
import coding.util.ArrayUtil;

public class MinRangeQuery {

    static void build(int a[], int s[], int low, int high, int pos){
        if(low==high){
            s[pos]=a[low];
            return;
        }
        int mid=(low+high)/2;
        build(a, s, low, mid, 2*pos+1);
        build(a,s,mid+1,high,2*pos+2);
        s[pos]=Math.min(s[2*pos+1],s[2*pos+2]);
    }

    static int[] buildSegmentTree(int a[]){
        int n=a.length;
        // s is the segment tree.
        int s[]=new int[2*NextPowerOf2.getNext(n)-1];
        build(a, s,0, n-1,0);
        return s;
    }

    static int min(int a[], int fromIndex, int toIndex){
        // Check for erroneous input values
        if (fromIndex < 0 || toIndex > a.length - 1 || fromIndex > toIndex)
        {
            System.err.println("Invalid input");
            return -1;
        }
        return getMin(a, buildSegmentTree(a), fromIndex, toIndex, 0, a.length-1, 0);
    }

    static int getMin(int a[], int s[], int qlow, int qhigh, int low, int high, int pos){
        if(qhigh<low || qlow>high)  return Integer.MAX_VALUE;
        if(qlow<=low && qhigh>=high)    return s[pos];
        int mid=(low+high)/2;
        int left=getMin(a, s, qlow, qhigh, low, mid, 2*pos+1);
        int right=getMin(a, s, qlow, qhigh, mid+1, high, 2*pos+2);
        return Math.min(left,right);
    }

    public static void main(String[] args) {
        int a[]=new int[]{-1,2,4,6,3,0};
        ArrayUtil.print(buildSegmentTree(a));
        System.out.println(min(a, 1,5));
    }
}
