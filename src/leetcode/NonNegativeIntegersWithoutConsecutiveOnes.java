package leetcode;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int n) {
        int[] fibonacci = new int[32];
        fibonacci[0] = 1;
        fibonacci[1] = 2;
        for(int i = 2; i < 32; ++i) fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        int ans = 0;
        int prevBit = 0;
        for(int i = 30; i >= 0; --i) {
            if((n & (1 << i)) != 0) { // check if bit at ith position is 1 or 0
                ans += fibonacci[i];
                if(prevBit == 1) {
                    return ans;
                }
                prevBit = 1;
            } else prevBit = 0;
        }
        return ans + 1;
    }
}
