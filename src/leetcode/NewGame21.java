package leetcode;

public class NewGame21 {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        dp[1] = 1.0 / maxPts;

        for(int i = 2; i <= n; ++i) {
            if(i <= k) {
                dp[i] = (1.0 + 1.0 / maxPts) * dp[i - 1];
            } else dp[i] = dp[i - 1];
            if( i > maxPts) dp[i] -= dp[i - maxPts - 1] / maxPts;
        }
        for(int i = 0; i <= n; ++i) System.out.print(i + "\t");
        System.out.println();
        for(int i = 0; i <= n; ++i) System.out.print(dp[i] + "\t");
        System.out.println();

        double ans = 0.0;
        for(int i = k; i <= n; ++i) ans+=dp[i];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NewGame21().new21Game(21,17, 10));
    }
}
