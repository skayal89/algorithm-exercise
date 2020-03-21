package coding.algo.dp;

public class MinJumps {

    static int getMinJumps(int a[], int n){
        int t[]=new int[n];
        int p[]=new int[n];
        t[0]=0;
        for(int i=1;i<n;i++){
            t[i]=Integer.MAX_VALUE;
            p[i]=-1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(j+a[j]>=i){
                    t[i]=Math.min(t[i],t[j]+1);
                }
            }
        }
        return t[n-1];
    }

    public static void main(String[] args) {
        int a[]=new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(getMinJumps(a,a.length));
    }
}
