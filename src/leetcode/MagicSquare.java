package leetcode;

import java.util.Arrays;

public class MagicSquare {

    public static int numMagicSquaresInside(int[][] grid) {

        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i <= m - 3; ++i) {
            for(int j = 0; j <= n - 3; ++j) {
                boolean magicSquare = true;
                boolean[] count = new boolean[10];
                for(int k = i; k < i + 3; ++k) {
                    for(int l = j; l < j + 3; ++l) {
                        if(grid[k][l] > 9 || grid[k][l] == 0) {
                            magicSquare = false;
                            break;
                        }
                        count[grid[k][l]] = true;
                    }
                    if(!magicSquare) break;
                }
                for(int l = 1; l <= 9; ++l) {
                    if (!count[l]) {
                        magicSquare = false;
                        break;
                    }
                }
                int[] sums = new int[8];
                int index = 0;
                for(int k = i; k < i + 3; ++k) {
                    int sum = 0;
                    for(int l = j; l < j + 3; ++l) {
                        sum += grid[k][l];
                    }
                    sums[index++] = sum;
                }
                for(int k = j; k < j + 3; ++k) {
                    int sum = 0;
                    for(int l = i; l < i + 3; ++l) {
                        sum += grid[l][k];
                    }
                    sums[index++] = sum;
                }
                int sum = 0;
                for(int k = 0; k < 3; ++k) {
                    sum += grid[i + k][j + k];
                }
                sums[index++] = sum;
                sum = 0;
                for(int k = 0; k < 3; ++k) {
                    sum += grid[i + k][j + 2 - k];
                }
                sums[index++] = sum;
                for(int k = 1; k < 8; ++k) {
                    if(sums[k] != sums[k - 1]) {
                        magicSquare = false;
                        break;
                    }
                }
                if(magicSquare) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numMagicSquaresInside(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}}));
    }
}
