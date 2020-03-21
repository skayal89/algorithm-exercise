package coding.ds.array;

/*
https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class SmallestSubarraySum {
    static int find(int a[], int n, int s){
        int i=0,j=0;
        int curr_sum=0, min_len=n+1;
        while(j<n){
            if(a[j]>s) return 1;
            curr_sum+=a[j];
            if(curr_sum>s){
                while(i<j && curr_sum>s){
                    if(min_len>j-i+1){
                        min_len=j-i+1;
                    }
                    curr_sum-=a[i++];
                }
            }
            j++;
        }
        return min_len;
    }

    public static void main(String[] args) {
        int a[]=new int[]{1, 4, 45, 6, 0, 19};
        System.out.println(find(a,a.length,51));
    }
}
