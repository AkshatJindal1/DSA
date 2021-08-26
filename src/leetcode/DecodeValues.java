package leetcode;

public class DecodeValues {

    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length];
        if(length == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        dp[0] = 1;
        int prevNum = (s.charAt(0) - '0');
        for(int curr = 1; curr < length; ++curr) {
            int currNum = s.charAt(curr) - '0';
            if(prevNum == 0 && currNum == 0) dp[curr] = 0;
            else if(prevNum == 0) dp[curr] = dp[curr -1];
            else if(currNum == 0) {
                if(prevNum == 1 || prevNum == 2)
                    dp[curr] = (curr >= 2) ? dp[curr - 2] : 1;
                else dp[curr] = 0;
            } else {
                if(prevNum * 10 + currNum <= 26)
                    dp[curr] = dp[curr - 1] + ((curr >= 2) ? dp[curr - 2] : 1);
                else dp[curr] = dp[curr - 1];
            }
            prevNum = currNum;
        }
        for(int i = 0; i < length; ++i) {
            System.out.print(s.charAt(i) + "\t");
        }
        System.out.println();
        for(int i = 0; i < length; ++i) {
            System.out.print(dp[i] + "\t");
        }
        System.out.println();
        return dp[length - 1];
    }

    public static void main(String[] args) {
        System.out.println("Ans : " + new DecodeValues().numDecodings("220011"));
    }
}
