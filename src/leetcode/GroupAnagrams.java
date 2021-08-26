package leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) { // MNlogN
        Map<String, List<String>> mp = new HashMap<>();
        for(String s: strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String a = new String(ch);
            mp.computeIfAbsent(a, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(mp.values());
    }

    public List<List<String>> groupAnagramsFast(String[] strs) { // MN but effectively will be slow because of map comparison for keys
        Map<Map<Character, Integer>, List<String>> mp = new HashMap<>();
        for(String s: strs) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for(char c: s.toCharArray()) {
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            }
            mp.computeIfAbsent(tempMap, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(mp.values());
    }

    public List<List<String>> groupAnagramsFastest(String[] strs) { // MN
        Map<Integer, List<String>> mp = new HashMap<>();
        for(String s: strs) {
            int hash = 0;
            for(char c: s.toCharArray()) {
                hash += c * (17 + c) * (23 + c) * (29 + c) * (41 + c);
            }
            mp.computeIfAbsent(hash, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(mp.values());
    }



    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(new GroupAnagrams().groupAnagramsFast(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(new GroupAnagrams().groupAnagramsFastest(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
