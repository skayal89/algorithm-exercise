package coding.ds.array;

import java.util.Arrays;

/*
    https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
    Implementation of Method 1 - O(m + n log m)
    Must read for other better methods
    My Video
 */
public class RelativeSort {

    static class Data{
        int val;
        boolean visited;

        Data(int x){
            val=x;
            visited=false;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "val=" + val +
                    ", visited=" + visited +
                    '}';
        }
    }

    void sort1(int a1[], int a2[]){
        int m=a1.length, n=a2.length;
        int j=0;
        Data t[]=new Data[m];
        for (int i=0;i<m;i++){
            t[i]=new Data(a1[i]);
        }
        Arrays.sort(t, (d1, d2) -> d1.val-d2.val);
        System.out.println(Arrays.toString(t));
        for (int i = 0; i < n; i++) {
            int index=first(t, a2[i]);
            System.out.println("Key:"+a2[i]+" First Index:"+index);
            if (index==-1)  continue;

            int k=index;
            while (k<m && t[k].val==t[index].val) {
                a1[j++] = t[k].val;
                t[k++].visited=true;
            }
        }
        System.out.println(Arrays.toString(t));
        // copy the elements which are not present in a2[]
        for (int i = 0; i < m; i++) {
            if(!t[i].visited){
                a1[j++]=t[i].val;
                t[i].visited=true;
            }
        }
    }

    int first(Data t[], int x){
        return binarySearch(t, x, 0, t.length-1);
    }

    int binarySearch(Data t[], int x, int low, int high){
        if(low==high && t[low].val==x && !t[low].visited){
            return low;
        }
        if(low<high){
            int mid=(low+high)/2;
            if(t[mid].val==x && (mid==low || (mid>low && t[mid-1].val!=x))) return mid;
            if(mid>low && t[mid-1].val>=x)  return binarySearch(t, x, low, mid-1);
            return binarySearch(t, x, mid+1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        int a1[] = new int[]{2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int a2[] = new int[]{2, 1, 8, 3};
        new RelativeSort().sort1(a1, a2);
        System.out.println(Arrays.toString(a1));
    }
}
