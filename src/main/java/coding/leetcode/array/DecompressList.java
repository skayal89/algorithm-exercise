package coding.leetcode.array;

public class DecompressList {
    public int[] decompressRLElist(int[] nums) {
        int resSize = getResultSize(nums);
        return decompress(nums,resSize);
    }

    private int getResultSize(int a[]){
        int sum = 0;
        for(int i=0;i<a.length;i += 2){
            sum += a[i];
        }
        return sum;
    }

    private int[] decompress(int a[], int resSize){
        int res[]=new int[resSize];
        int j=0;
        for(int i=0;i<a.length;i += 2){
            j = fill(res,j,a[i],a[i+1]);
        }
        return res;
    }

    private int fill(int res[], int j, int freq, int val){
        while(freq > 0){
            res[j++] = val;
            freq--;
        }
        return j;
    }
}
