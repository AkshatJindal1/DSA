package geeksforgeeks;

public class EggDropPuzzle {

    public int eggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];

        // only one floor = 1
        // for zero floor = 0
        for(int i = 1; i <= eggs; ++i) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        // for 1 egg, trails = number of floors
        for(int i = 1; i <= floors; ++i) {
            dp[1][i] = i;
        }

        for(int i = 2; i <= eggs; ++i) {
            for(int j = 2; j <= floors; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int x = 1; x <= j; ++x) {
                    int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][ j - x]);
                    if(dp[i][j] > res) dp[i][j] = res;
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String args[])
    {
        int n = 2, k = 36;
        System.out.println("Minimum number of trials in worst"
                + " case with "
                + n + "  eggs and "
                + k + " floors is " + new EggDropPuzzle().eggDrop(n, k));
    }
}
