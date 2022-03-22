package interviewbit.hashing;

import java.util.*;

public class ValidSudoku {

    int[][] grid;

    public int isValidSudoku(final List<String> A) {

        grid = new int[9][9];
        int k = 0;
        for(String s : A) {
            int j = 0;
            for(char c : s.toCharArray()) {
                grid[k][j++] = c - '0';
            }
            k++;
        }
        printGrid();
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                if(0 < grid[i][j] && grid[i][j] <= 9) {
                    if(!checkCol(i, j) || !checkRow(i, j) || !checkGrid(i, j)) return 0;
                }
            }
        }
        return 1;
    }

    private boolean checkRow(int row, int col){
        for(int i = 0; i < 9; ++i) {
            if(i == col) continue;
            if(grid[row][i] == grid[row][col]) return false;
        }
        return true;
    }

    private boolean checkCol(int row, int col) {
        for(int i = 0; i < 9; ++i) {
            if(i == row) continue;
            if(grid[i][col] == grid[row][col]) return false;
        }
        return true;
    }

    private boolean checkGrid(int row, int col) {
        int startRow = row - (row % 3);
        int endRow = startRow + 3;
        int startCol = col - (col % 3);
        int endCol = startCol + 3;
        for(int i = startRow; i < endRow; ++i) {
            for(int j = startCol; j < endCol; ++j) {
                if(i == row && j == col) continue;
                if(grid[i][j] == grid[row][col]) return false;
            }
        }
        return true;
    }

    private void printGrid() {
        for(int[] x: grid) {
            for(int i : x) System.out.print(i + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<String> sudoku = Arrays.asList("....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......");
        System.out.println(new ValidSudoku().isValidSudoku(sudoku));
    }
}
