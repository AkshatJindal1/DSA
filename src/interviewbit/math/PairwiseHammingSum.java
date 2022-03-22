package interviewbit.math;

import java.util.*;

public class PairwiseHammingSum {
    int MOD = 1000000007;
    public int hammingDistance(final List<Integer> A) {

        if(A.size() <= 1) return 0;
        int ans = 0;
        for(int i = 0; i < 32; ++i) {
            int ones = 0;
            int zeros = 0;
            for(int x : A) {
                if(x < 0) continue;
                if(((x >> i) & 1) == 1) ones++;
                else zeros++;
            }
            ans = (ans +  2 * (ones * zeros) % MOD) % MOD;
        }
        return ans;
    }
}
