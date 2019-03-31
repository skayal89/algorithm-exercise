package coding.ds.string;

public class ColumnNameToNumber {

    // same as binary to decimal. Consider base = 26
    static int getColumnNumber(String col){
        int base = 1;
        int res = 0;

        for (int i=col.length()-1;i>=0;i--){
            int val = (col.charAt(i)-'A')+1; // get the int value
            res += val * base; // adding new term to result
            base = base * 26; // generating the power of 26
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getColumnNumber("AB"));
        System.out.println(getColumnNumber("CDA"));
        System.out.println(getColumnNumber("AZ"));
    }
}
