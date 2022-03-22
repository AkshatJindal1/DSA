package interviewbit.dynamicprogramming;

import java.util.*;

public class MinSumPathInTriangle {
    public int minimumTotal(List<List<Integer>> a) {
        int n = a.size();
        int[] dp = new int[n];
        for(int i = 0; i < n; ++i) {
            dp[i] = a.get(n - 1).get(i);
        }
        System.out.println(Arrays.toString(dp));
        for(int i = n - 2; i >= 0; --i) {
            for(int j = 0; j < i + 1; ++j) {
                dp[j] = a.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(Collections.singletonList(2), Arrays.asList(6, 6), Arrays.asList(7, 8, 4));
        System.out.println(new MinSumPathInTriangle().minimumTotal(triangle));
    }

}
