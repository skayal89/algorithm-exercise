package coding.java8;

public class BitTest {

    /*
     * get number of set bits in binary representation using in-built function
     */
    public static int getNumberOfSetBits(int n){
        return Integer.bitCount(n);
    }
    public static void main(String[] args) {
        System.out.println(getNumberOfSetBits(6));
        System.out.println(getNumberOfSetBits(7));
        System.out.println(getNumberOfSetBits(8));
    }
}
