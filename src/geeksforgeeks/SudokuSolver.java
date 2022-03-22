package geeksforgeeks;

import java.util.Arrays;

public class SudokuSolver {

    private boolean isSafe(int[][] grid, int row, int col, int num) {
        int n = grid.length;
        int m = (int) Math.sqrt(n);
        for(int i = 0; i < n; ++i) {
            if (grid[row][i] == num) return false;
            if(grid[i][col] == num) return false;
        }
        int boxRowStart = row - row % m;
        int boxColStart = col - col % m;
        for(int i = boxRowStart; i < boxRowStart + m; ++i)
            for (int j = boxColStart; j < boxColStart + m; ++j)
                if(grid[i][j] == num) return false;

        return true;
    }

    public boolean solve(int[][] grid) {
        int n = grid.length;
        int row = -1, col = -1;
        boolean isEmpty = false;
        // Find empty cell
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = true;
                    break;
                }
            }
            if(isEmpty) break;
        }
        if(!isEmpty) return true;

        for(int i = 1; i <= n; ++i) {
            if(isSafe(grid, row, col, i)) {
                grid[row][col] = i;
                if(solve(grid)) return true;
                grid[row][col] = 0;
            }
        }
        return false;
    }

    public static void printGrid(int[][] grid) {
        for(int[] arr: grid) {
            for (int i : arr) System.out.print(i + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        if(new SudokuSolver().solve(grid))
            printGrid(grid);
        else System.out.println("No solution exists");
    }
}
