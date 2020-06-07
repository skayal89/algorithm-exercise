package coding.algo.recursion;

public class PrintReverseString {
    private static void printRecursion(char[] c, int curr, int n) {
        if (curr == n) {
            return;
        }
        printRecursion(c, curr + 1, n);
        System.out.print(c[curr]);
    }

    public static void main(String[] args) {
        String s = "hello";
        printRecursion(s.toCharArray(), 0, s.length());
    }
}
