package leetcode;

import java.util.Arrays;

public class Trie {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;

        TrieNode() {
            isEnd = false;
            Arrays.fill(children, null);
        }
    }

    TrieNode root = new TrieNode();

    void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;
        for(level = 0; level < length; ++level) {
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null) pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEnd = true;
    }

    boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for(level = 0; level < length; ++level) {
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null) return false;
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.isEnd;
    }

    boolean wordBreakSearch(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        boolean ans = false;
        for(level = 0; level < length; ++level) {
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null) return false;
            if(pCrawl.children[index].isEnd && level < length - 1) {
                ans |= wordBreakSearch(key.substring(level + 1));
            }
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.isEnd & ans;
    }
}
