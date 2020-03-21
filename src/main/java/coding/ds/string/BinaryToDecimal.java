package coding.ds.string;

public class BinaryToDecimal {

    static int toDecimal(String bin){
        int base = 1;
        int res = 0;

        for (int i=bin.length()-1;i>=0;i--){
            int val = (bin.charAt(i)-'0');
            res += val * base;
            base *= 2;
        }

        return res;
    }

    /*
     * 1*2^3 + 1*2^2 + 0*2^1 + 1*2^0
     * = 2 (1*2^2 + 1*2^1 + 0*2^0) + 1
     * = 2 (2 (1*2^1 + 1*2^0) + 0) + 1
     * = 2 (2 (2*(1) + 1) + 0) + 1
     *            ^ starting position = 2 * 0 + 1 = 1
     */
    static int toDecimal2(String bin){
        int res = 0;

        for (int i=0;i<bin.length();i++){ // traversing from first
            int val = (bin.charAt(i)-'0'); // get the int value
            res = 2 * res + val; // same as generating a number by multiplying with 10
        }

        return res;
    }

    static int convertToDecimal(String bin){
        return Integer.parseInt(bin, 2);
    }

    public static void main(String[] args) {
        System.out.println(toDecimal("11010100"));
        System.out.println(convertToDecimal("11010100"));
        System.out.println(convertToDecimal("1101"));

        System.out.println();
        System.out.println(toDecimal2("11010100"));
        System.out.println(toDecimal2("1101"));
    }
}
