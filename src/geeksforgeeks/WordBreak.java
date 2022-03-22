package geeksforgeeks;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {

    private boolean wordBreak(String str, String[] dictionary) {
        Set<String> dict = Arrays.stream(dictionary).collect(Collectors.toSet());
        int n = str.length();
        if(n == 0) return true;
        boolean[] dp = new boolean[n + 1]; // store if str[0, i] present in dict or not;
        List<Integer> matchedIndex = new ArrayList<>(); // store index for which word breaks upto that point is possible
        matchedIndex.add(-1);

        for(int i = 0; i < n; ++i) {
            boolean flag = false; // flag to see if break upto 'i' is present or not
            for(int j = matchedIndex.size() - 1; j >= 0; --j) {
                String sb = str.substring(matchedIndex.get(j) + 1, i + 1);
                System.out.println("start: " + (matchedIndex.get(j) + 1) + ", end: " + (i + 1) + " , " + sb + " => " + dict.contains(sb));
                if(dict.contains(sb)) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                dp[i] = true;
                matchedIndex.add(i);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        WordBreak ob = new WordBreak();
        String[] dictionary = { "mobile", "samsung",  "sam",  "sung", "man",
                "mango",  "icecream", "and",  "go",   "i",
                "like",   "ice",      "cream" };

        System.out.println(ob.wordBreak("ilikesamsung", dictionary));
        System.out.println(ob.wordBreak("iiiiiiii", dictionary));
        System.out.println(ob.wordBreak("", dictionary));
        System.out.println(ob.wordBreak("samsungandmango", dictionary));
        System.out.println(ob.wordBreak("samsungandmangok", dictionary));
    }
}
