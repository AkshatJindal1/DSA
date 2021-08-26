package leetcode;

import java.util.*;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> wordsInLine = new ArrayList<>();
        int charsLeft = maxWidth;
        for(String word : words) {
            if(charsLeft < word.length()) {
                System.out.println(charsLeft);
                int wordCount = wordsInLine.size();
                int spaces = charsLeft + wordCount;
                int minSpacesPossible = wordCount > 1 ? spaces / (wordCount - 1) : spaces;
                int spacesLeft = wordCount > 1 ? spaces % (wordCount - 1) : 0;
                StringBuilder sb = new StringBuilder();
//                System.out.println(spaces);
//                System.out.println(minSpacesPossible);
//                System.out.println(spacesLeft);
//                System.out.println();
                for(int i = 0; i < wordsInLine.size(); ++i) {
                    String w = wordsInLine.get(i);
                    if(i == wordsInLine.size() - 1) {
                        sb.append(w);
                        char[] spacesToBeFilled = new char[maxWidth - sb.length()];
                        Arrays.fill(spacesToBeFilled, ' ');
                        sb.append(spacesToBeFilled);
                    } else {
                        char[] spacesToBeFilled = new char[minSpacesPossible];
                        Arrays.fill(spacesToBeFilled, ' ');
                        sb.append(w).append(spacesToBeFilled);
                        if (spacesLeft-- > 0) sb.append(" ");
                    }
                }
                ans.add(sb.toString());
                charsLeft = maxWidth;
                wordsInLine = new ArrayList<>();
            }
            wordsInLine.add(word);
            charsLeft -= word.length(); charsLeft--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < wordsInLine.size(); ++i) {
            String w = wordsInLine.get(i);
            if(i == wordsInLine.size() - 1) {
                sb.append(w);
                char[] spacesToBeFilled = new char[maxWidth - sb.length()];
                Arrays.fill(spacesToBeFilled, ' ');
                sb.append(spacesToBeFilled);
            } else {
                sb.append(w).append(" ");
            }
        }
        ans.add(sb.toString());
        return ans;
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
//        tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).forEach(System.out::println);
//        System.out.println();
//        tj.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16).forEach(System.out::println);
//        System.out.println();
        tj.fullJustify(new String[]{"Science","is","what","we","understand","well","enough",
                "to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20).stream().map(s -> s.replace(' ', '-')).forEach(System.out::println);

    }
}
