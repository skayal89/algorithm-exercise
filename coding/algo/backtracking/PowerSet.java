package coding.algo.backtracking;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {
    void generateAllSubsets(int a[], int n){
        int res[]=new int[n];
        util(a,n,0,res,0);
    }

    void util(int a[], int n, int i, int res[], int j){
        if(i==n){
            printSubset(res,j);
            return;
        }
        util(a,n,i+1,res,j);
        res[j]=a[i];
        util(a, n, i+1, res, j+1);
    }

    void printSubset(int a[], int n){
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    void generateDistictSubsets(int a[], int n){
        Set<String> subsets=new HashSet<>();
        StringBuilder res=new StringBuilder();
        distinctSubsets(a, n, 0, res, 0, subsets);
        System.out.println(subsets);
    }

    void distinctSubsets(int a[], int n, int i, StringBuilder res, int j, Set<String> subsets){
        if(i==n){
            subsets.add(res.toString());
            return;
        }
        distinctSubsets(a,n,i+1,res,j,subsets);
        res.insert(j,a[i]);
        distinctSubsets(a,n,i+1,res,j+1,subsets);
        res.delete(j,res.length());
    }

    public static void main(String[] args) {
        System.out.println("All Subsets");
        new PowerSet().generateAllSubsets(new int[]{1,2,3,4},4);

        System.out.println("Distinct Subsets");
        new PowerSet().generateDistictSubsets(new int[]{1,2,2},3);
    }
}
