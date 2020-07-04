package coding.codeforces.contests;

import java.util.Scanner;

public class RequiredRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long n = sc.nextLong();
            System.out.println(requiredReminder(x, y, n));
        }
    }

    public static long requiredReminder(long x, long y, long n) {
        long r = n % x;
        long p = n - r + y;
        if (p <= n) return p;
        return p - x;
    }
}
