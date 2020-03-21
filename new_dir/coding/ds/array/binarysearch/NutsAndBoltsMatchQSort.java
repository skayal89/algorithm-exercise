package coding.ds.array.binarysearch;

import java.util.Arrays;

public class NutsAndBoltsMatchQSort {

    void match(char nuts[], char bolts[]){
        qsort(nuts, bolts, 0, nuts.length-1);
    }

    void qsort(char nuts[], char bolts[], int low, int high){
        if(low<high) {
            int p = partition(nuts, low, high, bolts[low]);
            partition(bolts, low, high, nuts[p]);
            qsort(nuts, bolts, low, p - 1);
            qsort(nuts, bolts, p + 1, high);
        }

    }

    int partition(char a[], int low, int high, char pivot){
        int l=low;
        for(int j=low;j<high;j++){
            if(a[j]<pivot){
                char temp=a[j];
                a[j]=a[l];
                a[l]=temp;
                l++;
            }
            else if(a[j]==pivot){
                char t=a[j];
                a[j]=a[high];
                a[high]=t;
                j--;
            }
        }
        char tm=a[l];
        a[l]=a[high];
        a[high]=tm;
        return l;
    }

    public static void main(String[] args) {
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        new NutsAndBoltsMatchQSort().match(nuts,bolts);
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}
