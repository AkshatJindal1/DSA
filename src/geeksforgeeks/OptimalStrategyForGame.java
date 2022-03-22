package geeksforgeeks;

public class OptimalStrategyForGame {

    private int optimalStrategyOfGame(int[] coins, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = coins[i];
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(coins[i], coins[i + 1]);
        }

        for (int k = 0; k < n - 1; k++) {
            int i = 0;
            for (int j =  k + 2; j < n; j++) {
                dp[i][j] = Math.max(
                        coins[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        coins[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
                ++i;
            }
        }

        printMatrix(dp);
        return dp[0][n - 1];

    }

    private void printMatrix(int[][] mat) {
        for(int[] ar: mat) {
            for(int n: ar) System.out.print(n + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        OptimalStrategyForGame ob = new OptimalStrategyForGame();
        int arr1[] = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println(ob.optimalStrategyOfGame(arr1, n));

        int arr2[] = { 2, 2, 2, 2 };
        n = arr2.length;
        System.out.println(ob.optimalStrategyOfGame(arr2, n));

        int arr3[] = { 20, 30, 2, 2, 2, 10 };
        n = arr3.length;
        System.out.println(ob.optimalStrategyOfGame(arr3, n));
    }
}
