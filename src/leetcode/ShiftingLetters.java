package leetcode;

import java.util.Arrays;

public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        for(int i =n - 2; i >= 0; --i) shifts[i] += shifts[i + 1] % 26;
        char[] ans = new char[n];
        for(int i = 0; i < n; ++i) ans[i] = (char)((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a');
        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(new ShiftingLetters().shiftingLetters("abc", new int[]{3, 5, 9}));
    }
}
