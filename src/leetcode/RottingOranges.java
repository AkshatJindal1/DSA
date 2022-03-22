package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class RottingOranges {
    int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int totalOranges = 0;
        int rottenOranges = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    ++rottenOranges;
                }
                if(grid[i][j] != 0) ++totalOranges;
            }
        }
        q.add(new int[]{-1, -1});
        int days = 0;
        while(!q.isEmpty()) {
            printMatrix(grid);
            System.out.println("Total:" + totalOranges + " Rotten: " + rottenOranges);
            int[] top = q.poll();
            if(top[0] == -1) {
                if(q.isEmpty()) {
                    if(rottenOranges == totalOranges) return days;
                    else return -1;
                }
                ++days;
                q.add(new int[]{-1, -1});
            }
            for(int[] move: moves) {
                int row = top[0] + move[0];
                int col = top[1] + move[1];

                if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                    grid[row][col] = 2;
                    ++rottenOranges;
                    q.add(new int[]{row, col});
                }
            }

        }
        return days;
    }

    private void printMatrix(int[][] mat) {
        for(int[] arr : mat) {
            for(int x : arr) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RottingOranges ob = new RottingOranges();

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//        System.out.println(ob.orangesRotting(grid));
//        grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        System.out.println(ob.orangesRotting(grid));
        StringBuilder sb = new StringBuilder();
        Arrays.stream("  hello world  ".split(" "))
                .filter(x -> x.length() > 0)
                .forEach(x -> sb.insert(0, x + " "));
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
