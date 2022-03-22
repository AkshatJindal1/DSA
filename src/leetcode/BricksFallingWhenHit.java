package leetcode;

import java.util.Arrays;

public class BricksFallingWhenHit {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int cols = grid[0].length;

        // Step 1
        for(int[] hit : hits) {
            int x = hit[0];
            int y = hit[1];

            grid[x][y]--; // make it 0 or -1 (if no brick at first place)
        }

        // Step 2
        int row = 0;
        for(int col = 0; col < cols; col++) {
            dfs(row, col, grid);
        }

        // Step 3
        int[] res = new int[hits.length];
        for(int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];

            grid[x][y]++; // if 0 then become 1 (if it was a brick initially)
            if(grid[x][y] == 1 && isConnectedToRoof(x, y, grid)) {
                res[i] = dfs(x, y, grid) - 1; // -1 because we added this grid[x][y] brick as well
            }
        }

        return res;
    }

    // this dfs() will check if the present cell of grid is Brick, and if it is brick then will convert it to 2 and gets the count of total bricks connected to this cell (similar to finding the num of islands)
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return dfs(i + 1, j, grid)
                + dfs(i - 1, j, grid)
                + dfs(i, j + 1, grid)
                + dfs(i, j - 1, grid) + 1;
    }

    // This checks if the present BRICK is connected to the roof (first row's BRICK) or not;
    // if yes, then next step would be to count the bricks
    // if no, then we do not need to worry about the brick
    private boolean isConnectedToRoof(int i,int j, int[][] grid) {
        if (i == 0) {
            return true;
        }
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BricksFallingWhenHit().hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}}, new int[][]{{1, 0}})));
    }

}
