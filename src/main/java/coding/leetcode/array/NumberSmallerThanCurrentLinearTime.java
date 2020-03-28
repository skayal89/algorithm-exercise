package coding.leetcode.array;

public class NumberSmallerThanCurrentLinearTime {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int count[] = countElements(nums);
        return buildResult(nums,count);
    }

    private int[] countElements(int a[]){
        int count[] = new int[101];
        for(int i : a){
            count[i]++;
        }
        for(int i=1;i<count.length;i++){
            count[i] += count[i-1];
        }
        return count;
    }

    private int[] buildResult(int a[], int count[]){
        int res[]=new int[a.length];

        for(int i=0;i<a.length;i++){
            res[i] = a[i]==0 ? 0 : count[a[i]-1];
        }
        return res;
    }
}
