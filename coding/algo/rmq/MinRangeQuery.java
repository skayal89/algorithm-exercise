package coding.algo.rmq;

import coding.algo.math.NextPowerOf2;
import coding.util.ArrayUtil;

public class MinRangeQuery {

    int s[];

    MinRangeQuery(int a[]){
        buildSegmentTree(a);
        ArrayUtil.print(s);
    }

    private void buildSegmentTree(int a[]){
        int n=a.length;
        s=new int[2*NextPowerOf2.getNext(n)-1];
        build(a,0, n-1,s,0);
    }

    private void build(int a[], int low, int high, int s[], int pos){
        if(low==high){
            s[pos]=a[low];
            return;
        }
        int mid=(low+high)/2;
        build(a, low, mid, s, 2*pos+1);
        build(a,mid+1,high, s,2*pos+2);
        s[pos]=Math.min(s[2*pos+1],s[2*pos+2]);
    }

    public int min(int a[], int fromIndex, int toIndex){
        // Check for erroneous input values
        if (fromIndex < 0 || toIndex > a.length - 1 || fromIndex > toIndex)
        {
            System.err.println("Invalid input");
            return -1;
        }
        return getMin(a, fromIndex, toIndex, 0, a.length-1, s, 0);
    }

    private int getMin(int a[], int qlow, int qhigh, int low, int high, int s[], int pos){
        if(qhigh<low || qlow>high)  return Integer.MAX_VALUE;
        if(qlow<=low && qhigh>=high)    return s[pos];
        int mid=(low+high)/2;
        int left=getMin(a, qlow, qhigh, low, mid, s, 2*pos+1);
        int right=getMin(a, qlow, qhigh, mid+1, high, s, 2*pos+2);
        return Math.min(left,right);
    }

    public static void main(String[] args) {
        int a[]=new int[]{-1,2,4,6,3,0};
        MinRangeQuery rangeQuery = new MinRangeQuery(a);
        System.out.println(rangeQuery.min(a, 2,4));
    }
}
