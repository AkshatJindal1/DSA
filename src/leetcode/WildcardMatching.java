package leetcode;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        boolean [][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 0; i < p.length(); i++)
            dp[0][i + 1] = dp[0][i] && p.charAt(i) == '*';
        for(int i = 0; i < s.length(); i++)
            dp[i + 1][0] = false;

        for(int i = 1; i <= s.length(); ++i)
            for(int j = 1; j <= p.length(); ++j) {
                char c = p.charAt(j - 1);
                if(c == '?') dp[i][j] = dp[i - 1][j - 1];
                else if(c == '*')
                    dp[i][j] = dp[i -1][j] || dp[i][j - 1];
                else dp[i][j] = dp[i - 1][j - 1] && c == s.charAt(i - 1);
            }
        return dp[s.length()][p.length()];
    }

}
