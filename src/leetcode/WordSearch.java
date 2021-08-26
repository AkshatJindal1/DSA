package leetcode;

public class WordSearch {

    String word;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        boolean isPresent;
        for(int i = 0; i < board.length; ++i)
            for(int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == word.charAt(0)) {
                    char temp = board[i][j];
                    board[i][j] = '*';
//                    visited[i][j] = true;
                    isPresent = search(i + 1, j,  1) ||
                            search(i - 1, j, 1) ||
                            search(i, j + 1, 1) ||
                            search(i, j - 1, 1);
                    if(isPresent) return true;
                    board[i][j] = temp;
//                    visited[i][j] = false;
                }
            }
        return false;

    }

    private boolean search(int x, int y, int index) {
        if(index == word.length()) return true;
        if(x >= 0 && x < board.length && y >=0 && y < board[0].length && board[x][y] == word.charAt(index)) {
            char temp = board[x][y];
            board[x][y] = '*';
            boolean isPresent = search(x + 1, y, index + 1) ||
                    search(x - 1, y, index + 1) ||
                    search(x, y + 1, index + 1) ||
                    search(x, y - 1, index + 1);
            board[x][y] = temp;
            return isPresent;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }
}
