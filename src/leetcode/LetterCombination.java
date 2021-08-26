package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombination {

    char[][] phone = {
            {}, {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u','v'},
            {'w', 'x', 'y', 'z'}
    };

    private List<String> letterCombinations(String digits, List<String> ans) {
        if(digits.length() == 0) return ans;
        char[] chars = phone[digits.charAt(0) - 48];
        List<String> temp = new ArrayList<>();
        for(char c: chars) {
            if(ans.size() == 0) {
                temp.add("" + c);
            }
            temp.addAll(ans.stream().map(a -> a + c).collect(Collectors.toList()));
        }
        return letterCombinations(digits.substring(1), temp);
    }

    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits, new ArrayList<>());
    }

    public static void main(String[] args) {
        System.out.println('0' - 48);
    }
}
