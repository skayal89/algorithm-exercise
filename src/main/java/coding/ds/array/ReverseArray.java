package coding.ds.array;

import coding.util.ArrayUtil;

public class ReverseArray {
    public static void main(String[] ar){
        int a[]=new int[]{4,2};
        reverse(a);
        ArrayUtil.print(a);
    }
    public static void reverse(int a[]){
        int l=0,h=a.length-1;
        while(l<h){
            int t=a[l];
            a[l]=a[h];
            a[h]=t;
            l++;
            h--;
        }
    }
}
