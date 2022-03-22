package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickFromBothSides {
    public int solve(List<Integer> A, int B) {
        System.out.println(A.size());
        int[] startSum = new int[A.size()];
        int[] endSum = new int[A.size()];
        int n = A.size();
        startSum[0] = A.get(0);
        endSum[n - 1] = A.get(n - 1);
        for(int i = 1; i < n; ++i) {
            startSum[i] = startSum[i - 1] + A.get(i);
            endSum[n - i - 1] = endSum[n - i] + A.get(n - i - 1);
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for(int i = 0; i < B - 1; ++i) {
            dp[i] = startSum[i] + endSum[n - B + i + 1];
            if(dp[i] > max) max = dp[i];
        }
        max = Math.max(Math.max(max, startSum[B - 1]), endSum[n - B]);

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new PickFromBothSides().solve(Arrays.asList(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35), 48));
    }
}
