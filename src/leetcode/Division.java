package leetcode;

public class Division {

    public static long div(long dividend, long divisor) {
        long sum = 0;
        long prevSum = 0;
        long ans = 0;

        while(sum + sum + divisor <= dividend) {
            sum += sum + divisor;
            ans += ans + 1;
            prevSum = sum;
        }

        long diff = dividend - prevSum;

        if(diff >= divisor)
            return ans + div(diff, divisor);
        return ans;
    }

    public static int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        long ans = div(Math.abs(x), Math.abs(y));
        System.out.println(ans);
        boolean negative = dividend < 0 ^ divisor < 0;
        if (negative) {
            ans = -ans;
        }
        if (ans > Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
        }
        return (int) ans;
    }



    public static void main(String[] args) {

        System.out.println(divide(-2147483648, -1));
    }
}
