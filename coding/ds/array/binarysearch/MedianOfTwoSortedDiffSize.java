package coding.ds.array.binarysearch;

public class MedianOfTwoSortedDiffSize {

    static double findMedian(int x[], int y[]){
        int m = x.length;
        int n = y.length;

        if(m > n) return findMedian(y,x);

        int low = 0, high = m;
        while (low <= high){
            int partitionX = (low + high)/2;
            int partitionY = ((m + n + 1)/2) - partitionX; // if we remove +1 then the answer will be wrong because we need to adjust for even and odd

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : x[partitionX-1];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : y[partitionY-1];

            int minRightX = partitionX == m ? Integer.MAX_VALUE : x[partitionX];
            int minRightY = partitionY == n ? Integer.MAX_VALUE : y[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((m+n)%2 == 0){
                    return ((double) Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2;
                }
                return (double)Math.max(maxLeftX,maxLeftY);
            }
            else if(maxLeftX > minRightY){
                high = partitionX - 1;
            }
            else{
                low = partitionX + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int x[]=new int[]{1,3,8,9,15};
        int y[]=new int[]{7,11,18,19,21,25};
        System.out.println(findMedian(x,y));

        int a[]=new int[]{23,26,31,35};
        int b[]=new int[]{3,5,7,9,11,16};
        System.out.println(findMedian(a,b));
    }
}
