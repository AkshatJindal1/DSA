package leetcode;

import java.util.Arrays;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        int[] charsS = new int[256];
        Arrays.fill(charsS, -1);
        int[] charsT = new int[256];
        Arrays.fill(charsT, -1);
        int n = s.length();
        for(int i = 0; i < n; ++i) {
            if(charsS[s.charAt(i)] != -1 && charsS[s.charAt(i)] != t.charAt(i)) return false;
            if(charsT[t.charAt(i)] != -1 && charsT[t.charAt(i)] != s.charAt(i)) return false;
            charsS[s.charAt(i)] = t.charAt(i);
            charsT[t.charAt(i)] = s.charAt(i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
