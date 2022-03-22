package geeksforgeeks;

public class InterleavedString {
    static boolean isInterleaved(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        if(m + n != C.length()) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];

        for(int i = 0; i <= m; ++i) {
            for(int j = 0; j <= n; ++j) {
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(i == 0) {
                    if(B.charAt(j - 1) == C.charAt(j - 1)) dp[i][j] = dp[i][j - 1];
                } else if(j == 0) {
                    if(A.charAt(i - 1) == C.charAt(i - 1)) dp[i][j] = dp[i - 1][j];
                }
                else if(A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1)) dp[i][j] = dp[i - 1][j];
                else if(A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) dp[i][j] = dp[i][j - 1];
                else if(A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }
        return dp[m][n];
    }

    static void test(String A, String B, String C) {
        if (isInterleaved(A, B, C))
            System.out.println(C + " is interleaved of " +
                    A + " and " + B);
        else
            System.out.println(C + " is not interleaved of " +
                    A + " and " + B);
    }

    // Driver code
    public static void main(String[] args)
    {
        test("XXY", "XXZ", "XXZXXXY");
        test("XY", "WZ", "WZXY");
        test("XY", "X", "XXY");
        test("YX", "X", "XXY");
        test("XXY", "XXZ", "XXXXZY");
    }
}
