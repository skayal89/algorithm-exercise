package coding.ds.array.binarysearch;

import coding.util.ArrayUtil;


public class MedianOfTwoArrays {
    public static void main(String[] ar){
        int a[]=new int[]{1,4,8,9};
        int b[]=new int[]{5,6,10,12};
        System.out.println(findMedian(a,b));
        //ArrayUtil.print(a);

        System.out.println(findMedian(new int[]{1,12,15,26,38},new int[]{2,13,17,30,45}));
        System.out.println(findMedian(new int[]{1,12,14},new int[]{27,30,45}));

    }

    public static double findMedian(int a[], int[] b){
        return findMedian(a,b,0,a.length-1,0,b.length-1);
    }

    public static double findMedian(int a[],int b[], int alow,int ahigh,int blow,int bhigh){
        int n=ahigh-alow+1;
        if(n<=0)    return -1;
        if(n==1)    return ((double) a[alow]+b[blow])/2;
        if(n==2)    return ((double) Math.max(a[alow],b[blow])+Math.min(a[ahigh],b[bhigh]))/2;
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
