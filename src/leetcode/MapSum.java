package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class MapSum {

    static class TrieNode {
        TrieNode[] children;
        int value;

        TrieNode() {
            children = new TrieNode[26];
            Arrays.fill(children, null);
            value = 0;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + Arrays.stream(children).filter(Objects::nonNull).collect(Collectors.toList()) +
                    ", value=" + value +
                    '}';
        }
    }

    TrieNode search(String key) {
        TrieNode pCrawl = root;

        for(int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                return null;

            pCrawl = pCrawl.children[index];
        }
        return pCrawl;
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode pCrawl = root;

        for(int i = 0; i < key.length(); i++)
        {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.value = val;
    }

    public int sum(String prefix) {
        TrieNode p = search(prefix);
        if(p == null) return 0;
        int sum = 0;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(p);
        while(!q.isEmpty()) {
//            System.out.println(q);
            TrieNode head = q.poll();
            sum += head.value;
            for(TrieNode node: head.children)
                if(node != null) q.add(node);
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum mp = new MapSum();
        mp.insert("apple", 3);
        System.out.println(mp.sum("ap"));
        mp.insert("app", 2);
        System.out.println(mp.sum("ap"));
    }
}