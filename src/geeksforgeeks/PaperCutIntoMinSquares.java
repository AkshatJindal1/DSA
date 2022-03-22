package geeksforgeeks;


public class PaperCutIntoMinSquares {

    public static void main(String[] args) {
        int m = 30, n = 35;

        // Function call
        System.out.println(minimumSquare(m, n));
    }

    private static int[][] dp = new int[300][300];
    private static int minimumSquare(int m, int n) {
        if(m == n) return 1;
        if(dp[m][n] != 0) return dp[m][n];
        int verticalMin = Integer.MAX_VALUE;
        int horizontalMin = Integer.MAX_VALUE;

        for(int i = 1; i <= m / 2; ++i) {
            verticalMin = Math.min(minimumSquare(i, n) + minimumSquare(m - i, n), verticalMin);
        }
        for(int i = 1; i <= n / 2; ++i) {
            horizontalMin = Math.min(minimumSquare(m, i) + minimumSquare(m, n - i), horizontalMin);
        }
        dp[m][n] = Math.min(horizontalMin, verticalMin);
        return dp[m][n];
    }
}
