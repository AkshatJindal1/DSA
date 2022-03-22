package interviewbit.math;

import java.util.Arrays;

public class PrimeSum {
    public int[] primesum(int A) {
        boolean[] primes = new boolean[A + 1];
        for(int i = 0; i < A + 1; ++i) primes[i] = true;
        for(int i = 2; i * i <= A; ++i) {
            if(primes[i]) {
                for(int j = i + i; j <= A; j += i)
                    primes[j] = false;
            }
        }
        int[] ans = new int[2];

        for(int i = 2; i <= A/2; ++i) {
            if(primes[i] && primes[A - i]) {
                ans[0] = i;
                ans[1] = A - i;
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrimeSum().primesum(4)));
    }
}
