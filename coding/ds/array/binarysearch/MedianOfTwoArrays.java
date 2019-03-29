package coding.ds.array.binarysearch;

import coding.util.ArrayUtil;


public class MedianOfTwoArrays {
    public static void main(String[] ar){
        int a[]=new int[]{1,4,8,9};
        int b[]=new int[]{5,6,10,12};
        System.out.println(findMedian(a,b,0,a.length-1,0,b.length-1));
        //ArrayUtil.print(a);
    }

    public static int findMedian(int a[],int b[], int alow,int ahigh,int blow,int bhigh){
        int n=ahigh-alow+1;
        if(n<=0)    return -1;
        if(n==1)    return (a[alow]+b[blow])/2;
        if(n==2)    return (Math.max(a[alow],b[blow])+Math.min(a[ahigh],b[bhigh]))/2;
        int amid=(alow+ahigh)/2;
        int bmid=(blow+bhigh)/2;

        if(a[amid]==b[bmid])    return a[amid];
        else if(a[amid]<b[bmid]){
            if(n%2==0){
                return findMedian(a,b,amid,ahigh,blow,bmid+1);
            }
            return findMedian(a,b,amid,ahigh,blow,bmid);
        }
        else {
            if(n%2==0){
                return findMedian(a,b,alow,amid+1,bmid,bhigh);
            }
            return findMedian(a,b,alow,amid,bmid,bhigh);
        }
    }

}
