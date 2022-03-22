package geeksforgeeks;

import java.util.Arrays;

public class Boogle {

    private int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean leaf;
        public TrieNode() {
            leaf = false;
            Arrays.fill(child, null);
        }
    }

    public static void insertInTrie(TrieNode root, String word) {
        int n = word.length();
        TrieNode next = root;
        for(char c: word.toCharArray()) {
            int index = c - 'A';
            if(next.child[index] == null)
                next.child[index] = new TrieNode();
            next = next.child[index];
        }
        next.leaf = true;
    }

    private boolean isSafe(boolean[][] visisted, int i, int j) {
        int m = visisted.length;
        int n = visisted[0].length;
        return (i >= 0 && i < m && j >= 0 && j < n && !visisted[i][j]);
    }

    private void searchWord(TrieNode root, char[][] boggle, int i, int j, boolean[][] visited, String str) {
        if(root.leaf) System.out.println(str);
        if(isSafe(visited, i , j)) {
            visited[i][j] = true;
            for(int k = 0; k < 26; ++k) {
                if(root.child[k] != null) {
                    char ch = (char)(k + 'A');
                    for(int[] move: moves) {
                        if(isSafe(visited, i + move[0], j + move[1])
                                && boggle[i + move[0]][j + move[1]] == ch)
                            searchWord(root.child[k], boggle, i + move[0], j + move[1], visited, str + ch);
                    }
                }
            }
            visited[i][j] = false;
        }
    }

    public void findWords(char[][] boggle, TrieNode root) {
        int m = boggle.length;
        int n = boggle[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(root.child[boggle[i][j] - 'A'] != null) {
                    searchWord(root.child[boggle[i][j] - 'A'], boggle, i, j, visited, "" + boggle[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GEE" };

        // root Node of trie
        TrieNode root = new TrieNode();

        // insert all words of dictionary into trie
        int n = dictionary.length;
        for (int i = 0; i < n; i++)
            insertInTrie(root, dictionary[i]);

        char boggle[][] = { { 'G', 'I', 'Z' },
                { 'U', 'E', 'K' },
                { 'Q', 'S', 'E' } };

        new Boogle().findWords(boggle, root);
    }
}
