package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class NQueens {

    List<List<String>> ans;
    Set<Integer> selectedCol = new HashSet<>();
    Set<Integer> positiveDiagonal = new HashSet<>();
    Set<Integer> negativeDiagonal = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        createBoard(board, 0, n);
        return ans;
    }

    private void createBoard(char[][] board, int i, int n) {
        if(i == n) {
            ans.add(Arrays.stream(board).map(String::new).collect(Collectors.toList()));
            return;
        }
        for(int j = 0; j < n; ++j) {
            if(selectedCol.contains(j)
                    || positiveDiagonal.contains(i + j)
                    || negativeDiagonal.contains(i - j))
                continue;

            selectedCol.add(j);
            positiveDiagonal.add(i + j);
            negativeDiagonal.add(i - j);
            board[i][j] = 'Q';
            createBoard(board, i + 1, n);
            selectedCol.remove(j);
            positiveDiagonal.remove(i + j);
            negativeDiagonal.remove(i - j);
            board[i][j] = '.';
        }
    }

    public static void main(String[] args) {
        NQueens ob = new NQueens();
        System.out.println(ob.solveNQueens(9));
    }
}
