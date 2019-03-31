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

    static int convertToDecimal(String bin){
        return Integer.parseInt(bin, 2);
    }

    public static void main(String[] args) {
        System.out.println(toDecimal("11010100"));
        System.out.println(convertToDecimal("11010100"));
    }
}
