package coding.ds.string;

public class StringCompression {
    public static void main(String[] args) {
        String s="abcdefhrgjj";
        System.out.println(compress(s));
    }

    private static String compress(String s){
        if(s==null) return s;
        String r="";
        StringBuilder sb=new StringBuilder(r);
        int i=0, n=s.length();
        while(i<n){
            int j=i+1;
            while (j<n && s.charAt(i)==s.charAt(j)){
                j++;
            }
            sb.append(s.charAt(i));
            sb.append(j-i);
            i=j;
        }
        r=sb.toString();
        if(r.length()<s.length())
            return r;
        return s;
    }
}
