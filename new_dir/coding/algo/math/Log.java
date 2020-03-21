package coding.algo.math;

public class Log {
    static int log2Rec(int n){ // log base 2
        return n>1 ? 1+log2Rec(n/2) : 0;
    }

    static int log2Iter(int n){
        int count=0;
        while(n>1){
            count++;
            n = n/2;
        }
        return count;
    }

    static int logrRec(int n, int r){ // log base r
        return n>r-1 ? 1+logrRec(n/r, r) : 0;
    }

    public static void main(String[] args) {
        System.out.println(logrRec(7,2));
        System.out.println(log2Rec(7));
        System.out.println(log2Iter(7));
    }
}
