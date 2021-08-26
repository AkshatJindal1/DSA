package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    Map<String, Map<String, Boolean>> dp = new HashMap<>();

    private boolean isAnagram(String s1, String s2) {
        int[] count = new int[26];
        for(int i = 0; i < s1.length(); ++i) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for(int i: count) if(i != 0) return false;
        return true;
    }

    public boolean isScramble(String s1, String s2) {
        if(!isAnagram(s1, s2)) return false;
        if(s1.equals(s2)) return true;
        if(dp.containsKey(s1) && dp.get(s1).containsKey(s2)) return dp.get(s1).get(s2);

        boolean ans = false;
        for(int i = 1; i < s1.length(); ++i) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                ans = true; break;
            }
            if(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))){
                ans = true; break;
            }
        }
        dp.putIfAbsent(s1, new HashMap<>());
        dp.get(s1).put(s2, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));
    }
}
