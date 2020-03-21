package coding.ds.string;

public class ColumnNameToNumber {

    // same as binary to decimal. Consider base = 26
    static int getColumnNumber(String col){
        int base = 1;
        int res = 0;

        for (int i=col.length()-1;i>=0;i--){ // traversing from last
            int val = (col.charAt(i)-'A')+1; // get the int value
            res += val * base; // adding new term to result
            base = base * 26; // generating the power of 26
        }

        return res;
    }

    static int getColumnNumber2(String col){
        int res = 0;

        for (int i=0;i<col.length();i++){ // traversing from first
            int val = (col.charAt(i)-'A')+1; // get the int value
            res = 26 * res + val; // same as generating a number by multiplying with 10
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getColumnNumber("AB"));
        System.out.println(getColumnNumber("CDA"));
        System.out.println(getColumnNumber("AZ"));

        System.out.println();
        System.out.println(getColumnNumber2("AB"));
        System.out.println(getColumnNumber2("CDA"));
        System.out.println(getColumnNumber2("AZ"));
    }
}
