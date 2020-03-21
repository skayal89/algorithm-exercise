package coding.ds.string;

public class RomanToDecimal {

    static int toDecimal(String roman){
        int n=roman.length();
        int res = 0;
        for(int i=0;i<n;i++){
            int val = value(roman.charAt(i));
            if(i<n-1){
                int x=value(roman.charAt(i+1));
                res += (x > val ? -1 * val : val);
            }
            else res += val;
        }
        return res;
    }

    static int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(toDecimal("IX"));
        System.out.println(toDecimal("XL"));
        System.out.println(toDecimal("MCMIV"));
        System.out.println(toDecimal("MMMDXLIX"));
    }
}
