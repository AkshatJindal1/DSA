package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j) {
                ans[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE - 1;
                if(mat[i][j] == 0) queue.add(new int[]{i, j});
            }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()) {
            int[] element = queue.poll();
            for(int[] d: directions) {
                int row = element[0] + d[0];
                int col = element[1] + d[1];
                if(row >= 0 && col >= 0 && row < m && col < n) {
                    if(ans[row][col] > ans[element[0]][element[1]] + 1) {
                        ans[row][col] = ans[element[0]][element[1]] + 1;
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Matrix01().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
