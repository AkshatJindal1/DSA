package leetcode;

import java.util.*;

public class MinimumWindowSubstring {

    static class Pair<X, Y> {
        X first;
        Y second;

        public Pair(X first, Y second) {
            this.first = first;
            this.second = second;
        }
    }

    public String minWindowSimpler(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : t.toCharArray()) {
            int count = mp.getOrDefault(ch, 0);
            mp.put(ch, count + 1);
        }
        int count = mp.size();
        boolean found = false;

        int left = 0; int right = s.length() - 1;
        int minLength = s.length();

        int i = 0; int j = 0;

        while(j < s.length()) {
            char ch = s.charAt(j++);
            if(mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
                if(mp.get(ch) == 0) count--;
            }

            if(count > 0) continue;

            while(count == 0) {
                ch = s.charAt(i++);
                if(mp.containsKey(ch)) {
                    mp.put(ch, mp.get(ch) + 1);
                    if(mp.get(ch) > 0) ++count;
                }
            }
            if(j - i < minLength) {
                left = i;
                right = j;
                minLength = right - left;
                found = true;
            }
        }
        return found ? s.substring(left - 1, right) : "";
    }

    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : t.toCharArray()) {
            int count = mp.getOrDefault(ch, 0);
            mp.put(ch, count + 1);
        }

        List<Pair<Character, Integer>> filteredS = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(mp.containsKey(ch)) filteredS.add(new Pair<>(ch, i));
        }

        int uniqueChars = mp.size();
        int left = 0;
        int right = 0;


        int uniqueCharsMatched = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = {-1, 0 , 0}; // size, left, right;

        while(right < filteredS.size()) {
            char ch = filteredS.get(right).first;
            int count = windowCounts.getOrDefault(ch, 0);
            windowCounts.put(ch, count + 1);

            if(mp.containsKey(ch) && windowCounts.get(ch).equals(mp.get(ch))) ++uniqueCharsMatched;

            while(left <= right && uniqueCharsMatched == uniqueChars) {
                char c = filteredS.get(left).first;
                int start = filteredS.get(left).second;
                int end = filteredS.get(right).second;
                if(ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if(mp.containsKey(c) && mp.get(c) > windowCounts.get(c)) --uniqueCharsMatched;
                ++left;
            }
            ++right;
        }
        if(ans[0] == -1) return "";
        return s.substring(ans[1], ans[2] + 1);
    }
}
