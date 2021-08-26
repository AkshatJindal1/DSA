package leetcode;

import java.util.Arrays;

public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        boolean[] present = new boolean[9];
        for(int i = 0; i < 9; ++i) {
            Arrays.fill(present, false);
            for(int j = 0; j < 9; ++j){
                if(board[i][j] == '.') continue;
                if(present[board[i][j] - '1']) return false;
                present[board[i][j]- '1'] = true;
            }
            Arrays.fill(present, false);
            for(int j = 0; j < 9; ++j){
                if(board[j][i] == '.') continue;
                if(present[board[j][i] - '1']) return false;
                present[board[j][i]- '1'] = true;
            }
        }

        for(int x = 0; x < 9; x+=3) {
            for(int y = 0; y < 9; y+=3) {
                Arrays.fill(present, false);
                for (int i = x; i < x + 3; ++i) {
                    for (int j = y; j < y + 3; ++j) {
                        if(board[i][j] == '.') continue;
                        if (present[board[i][j] - '1']) return false;
                        present[board[i][j] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }

    public void printMatrix(char[][] mat) {
        for(char[] chars: mat) {
            for(char i: chars)
                System.out.print(i + "\t");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ValidSudoko ob = new ValidSudoko();
//        System.out.println(ob.isValidSudoku(new char[][]{
//                {'8','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}}));

        ob.printMatrix(new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}});

        System.out.println(ob.isValidSudoku(new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}}));
    }
}
