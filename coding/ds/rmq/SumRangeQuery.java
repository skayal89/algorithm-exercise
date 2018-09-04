package coding.ds.rmq;

import coding.algo.math.NextPowerOf2;
import coding.util.ArrayUtil;

public class SumRangeQuery {

    static void build(int a[], int s[], int low, int high, int pos){
        if(low==high){
            s[pos]=a[low];
            return;
        }
        int mid=(low+high)/2;
        build(a, s, low, mid, 2*pos+1);
        build(a,s,mid+1,high,2*pos+2);
        s[pos]=s[2*pos+1]+s[2*pos+2];
    }

    static int[] buildSegmentTree(int a[]){
        int n=a.length;
        // s is the segment tree.
        int s[]=new int[2* NextPowerOf2.getNext(n)-1];
        build(a, s,0, n-1,0);
        return s;
    }

    static int sum(int a[], int fromIndex, int toIndex){
        return getSum(a, buildSegmentTree(a), fromIndex, toIndex, 0, a.length-1, 0);
    }

    static int getSum(int a[], int s[], int qlow, int qhigh, int low, int high, int pos){
        if(qhigh<low || qlow>high)  return 0;
        if(qlow<=low && qhigh>=high)    return s[pos];
        int mid=(low+high)/2;
        int left= getSum(a, s, qlow, qhigh, low, mid, 2*pos+1);
        int right= getSum(a, s, qlow, qhigh, mid+1, high, 2*pos+2);
        return left+right;
    }

    public static void main(String[] args) {
        int a[]=new int[]{-1,2,4,6,3,0};
        ArrayUtil.print(buildSegmentTree(a));
        System.out.println(sum(a,1,3));
    }
}
