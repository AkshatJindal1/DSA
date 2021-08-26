package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    Map<String, Boolean> dp;
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            Arrays.fill(children, null);
            isEndOfWord = false;
        }
    }

    static void insert(TrieNode root, String key) {
        TrieNode pCrawl = root;

        for(int i = 0; i < key.length(); i++)
        {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    static boolean search(TrieNode root, String key) {
        TrieNode pCrawl = root;

        for(int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    boolean find(String str, TrieNode root) {
        TrieNode pCrawl = root;
        for(int i = 0; i < str.length(); ++i) {
            System.out.println(dp);
            int index = str.charAt(i) - 'a';
            if(pCrawl.children[index] == null) return false;
            if(pCrawl.children[index].isEndOfWord) {
                String subString = str.substring(i + 1);
                System.out.println(subString);
                if(!dp.containsKey(subString))
                    dp.put(subString, find(subString, root));
                System.out.println(dp);
                if(dp.get(subString)) return true;
            }
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.isEndOfWord;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        dp = new HashMap<>();
        wordDict.forEach(word -> insert(root, word));
        return find(s, root);
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
