package leetcode;

public class IntegerBreak {
    public int integerBreak(int n) {
        /*
        *
        * n = 2 => 1
        * n = 3 => 2
        * for n >= 4 =>
        *   we want to get as many 3s ans 2s giving preference to 3s
        *   n % 3 = 2 (eg: 5) break it into 3s and 2
        *   n % 3 = 0 break it inot all 3s  3 ^ breaks
        *   n % 3 = 1 (eg: 7) break into into 3s and two 2s
        * */
        if(n == 2) return 1;
        if(n == 3) return 2;
        int divisor = n / 3;
        int remainder = n % 3;
        if(remainder == 0) return (int)Math.pow(3, divisor);
        if(remainder == 2) return (int)Math.pow(3, divisor) * 2;
        return (int)Math.pow(3, divisor - 1) * 4;
    }
}
