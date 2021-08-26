package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatinationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> map = new HashMap<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0) + 1);

        int wordLength = words[0].length();
        int substringLength = wordLength * words.length;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i <=  s.length() - substringLength; ++i) {
            String possibleString = s.substring(i, i + substringLength);
            System.out.println(possibleString);
            Map<String, Integer> tempMap = new HashMap<>(map);
            for(int j = 0; j < substringLength; j+=wordLength) {
                String word = possibleString.substring(j, j + wordLength);
                if(!tempMap.containsKey(word)) break;
                tempMap.put(word, tempMap.get(word) - 1);
                if(tempMap.get(word) == 0) tempMap.remove(word);
            }
            if(tempMap.size() == 0) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatinationOfAllWords().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
}
