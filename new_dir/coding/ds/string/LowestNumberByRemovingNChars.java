package coding.ds.string;

/*
https://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
[Hard]
 */
public class LowestNumberByRemovingNChars {
    static StringBuilder res;
    static void getLowestNumberUtil(String s, int n){
        if(n==0){
            res.append(s);
            return;
        }
        if(n>=s.length())   return;
        int minIndex=0;
        for (int i=1;i<n+1;i++){
            if(s.charAt(i)<s.charAt(minIndex)){
                minIndex=i;
            }
        }
        res.append(s.charAt(minIndex));
        getLowestNumberUtil(s.substring(minIndex+1),n-minIndex);
    }

    static String getLowestNumber(String s, int n){
        res=new StringBuilder();
        getLowestNumberUtil(s, n);
        return res.toString();
    }

    public static void main(String[] args) {
        String s1="4325043";
        String s2="121198";
        String s3="765028321";
        System.out.println(getLowestNumber(s1,3));
        System.out.println(getLowestNumber(s2,2));
        System.out.println(getLowestNumber(s3,5));
    }
}
