package leetcode;

import java.util.Arrays;

public class CustomSortString {
    public static String customSortString(String order, String str) {
        int[] count = new int[26];
        for(char c: str.toCharArray())
            count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(char c: order.toCharArray()) {
            char[] cs = new char[count[c - 'a']];
            Arrays.fill(cs, c);
            sb.append(String.valueOf(cs));
            count[c - 'a'] = 0;
        }
        for(int i = 0; i < 26; ++i) {
            if(count[i] > 0) {
                char[] cs = new char[count[i]];
                Arrays.fill(cs, (char)(i + 'a'));
                sb.append(String.valueOf(cs));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }
}
