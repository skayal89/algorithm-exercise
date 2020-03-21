package coding.ds.string;

public class AllPermutation {
    static void permutations(String s){
        util(s.toCharArray(),0);
    }

    static void util(char[] c, int start){
        if(start==c.length){
            System.out.println(new String(c));
        }
        for(int i=start;i<c.length;i++){
            swap(c,start,i);
            util(c,start+1);
            swap(c,start,i);
        }
    }

    static void swap(char[] c, int i, int j){
        char ch=c[i];
        c[i]=c[j];
        c[j]=ch;
    }

    public static void main(String[] args) {
        String s="abcd";
        permutations(s);
    }
}
