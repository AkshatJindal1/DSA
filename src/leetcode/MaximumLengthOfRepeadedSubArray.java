package leetcode;

public class MaximumLengthOfRepeadedSubArray {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 0;
        for(int i = 0; i < m; ++i) {
            dp[i][n] = 0;
        }
        for(int i = 0; i < n; ++i) {
            dp[m][i] = 0;
        }
        int ans = 0;
        for(int i = m - 1; i >= 0; --i) {
            for(int j = n -1; j >= 0; --j) {
                if(nums1[i] == nums2[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else dp[i][j] = 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfRepeadedSubArray().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4}));
    }
}
