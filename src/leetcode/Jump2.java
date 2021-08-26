package leetcode;

public class Jump2 {

    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i= n - 2; i>=0; --i) {
            int minJumps = n;
            for(int j = 1; j <= nums[i]; ++j) {
                int currentIndex = i + j;
                if(currentIndex < n && dp[currentIndex] + 1 < minJumps)
                    minJumps = dp[currentIndex] + 1;
            }
            dp[i] = minJumps;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
