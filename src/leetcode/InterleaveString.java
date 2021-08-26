package leetcode;

public class InterleaveString {

    char[] s1;
    char[] s2;
    char[] s3;
    short[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        this.s3 = s3.toCharArray();
        dp = new short[s1.length()][s2.length()];
        return solve(0, 0, 0);
    }

    boolean solve(int i1, int i2, int i3) {
//        System.out.println(i1 + " " + i2 + " " + i3 + " " + s3[i3]);
        if(i1 == s1.length) return String.valueOf(s2).substring(i2).equals(String.valueOf(s3).substring(i3));
        if(i2 == s2.length) return String.valueOf(s1).substring(i1).equals(String.valueOf(s3).substring(i3));
        if(dp[i1][i2] > 0) return dp[i1][i2] == 2;

        boolean ans = s3[i3] == s1[i1] && solve(i1 + 1, i2, i3 + 1) || s3[i3] == s2[i2] && solve(i1, i2 + 1, i3 + 1);
        dp[i1][i2] = ans ? (short) 2 : 1;
        return ans;
    }

    public static void main(String[] args) {
        InterleaveString is = new InterleaveString();
        System.out.println(is.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
