package leetcode;

public class UniqueBst {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= n; ++i) {
            for(int j = 1; j <= i; ++j) {
                dp[i] += dp[i -j] * dp[j -1];
            }
        }
        return dp[n];
    }

    public int fact(int n) {
        int ans = 1;
        for(int i = 1; i <=n; ++i) ans *= i;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Unique BST : " + new UniqueBst().numTrees(10));
        System.out.println("Unique BT :  " + (new UniqueBst().numTrees(10) * new UniqueBst().fact(10)));
    }
}
