package leetcode;

import java.util.Arrays;

public class PalindromePartitioning2 {

    public int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n + 1];
        for(int i = 0; i <= n; ++i) cut[i] = i - 1;

        System.out.println(Arrays.toString(cut));
        for(int i = 0; i < n; ++i) {
            for(int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); ++j) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j] + 1);
                System.out.print("1: " + i + " " + j + " : ");
                System.out.println(Arrays.toString(cut));
            }
            for(int j = 1; i - j + 1>= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j); ++j) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j + 1] + 1);
                System.out.print("2: " + i + " " + j + " : ");
                System.out.println(Arrays.toString(cut));
            }
        }
        System.out.println(Arrays.toString(cut));
        return cut[n];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning2().minCut("aaa"));
        System.out.println(new PalindromePartitioning2().minCut("ababbbabbababa"));
    }
}
