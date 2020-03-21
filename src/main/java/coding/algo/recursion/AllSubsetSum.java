package coding.algo.recursion;
/*
 * https://www.geeksforgeeks.org/print-sums-subsets-given-set/
 * Print sums of all subsets of a given set
 */
public class AllSubsetSum {

    static void printAllSubsetSum(int a[],int n, int sum){
        if(n==0){
            System.out.println(sum);
            return;
        }
        printAllSubsetSum(a,n-1,sum);
        printAllSubsetSum(a,n-1, sum+a[n-1]);
    }

    public static void main(String[] args) {
        int a[]=new int[]{5,4,3};
        printAllSubsetSum(a,a.length,0);
    }
}
