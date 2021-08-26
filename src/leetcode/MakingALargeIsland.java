package leetcode;

import java.util.*;

public class MakingALargeIsland {

    int[][] grid;
    int n;
    Map<Integer, Integer> islandArea;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        this.islandArea = new HashMap<>();
        this.grid = grid;
        n = grid.length;
        if(n == 0) return 0;
        int islandNumber = 2;
        // Get individual islands without doing any change
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                if(grid[i][j] == 1) {
                    int area = dfs(i, j, islandNumber);
                    islandArea.put(islandNumber++, area);
                }
        // ------------------------------------------------

        if(islandArea.isEmpty()) return 1; // case when only zeros are there
        if(islandArea.get(2) == n * n) return n * n; // case when all are 1

        int maxArea = 0;
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 0) { // get max area by changing 0 to 1 and connecting its neighbour islands
                    Set<Integer> neighbours = new HashSet<>();
                    for (int[] move : directions) {
                        int newI = i + move[0];
                        int newJ = j + move[1];
                        if (newI >= 0 && newJ >= 0 && newI < n && newJ < n && grid[newI][newJ] != 0)
                            neighbours.add(grid[newI][newJ]);
                    }
                    int area = 1;
                    if(!neighbours.isEmpty()) {
                        for(int neighbour: neighbours) area += islandArea.get(neighbour);
                    }
                    if(maxArea < area) maxArea = area;
                }
            }
        return maxArea;

     }

     private int dfs(int i, int j, int island) {
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || grid[i][j] == island) return 0;
        grid[i][j] = island;
        int area = 1;
        for(int[] moves: directions) {
            int newI = i + moves[0];
            int newJ = j + moves[1];
            area += dfs(newI, newJ, island);
        }
        return area;
     }

    public static void main(String[] args) {
        MakingALargeIsland ob = new MakingALargeIsland();
        int[][] grid = {{1, 0}, {0, 1}};
        System.out.println(ob.largestIsland(grid));
        System.out.println(ob.largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }
}
