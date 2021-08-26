package leetcode;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int num = 1;
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; ++i) ans[top][i] = num++;
            for(int i = top + 1; i <= bottom; ++i) ans[i][right] = num++;
            if(left < right && top < bottom) {
                for(int i = right - 1; i > left; --i) ans[bottom][i] = num++;
                for(int i = bottom; i > top; --i) ans[i][left] = num++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return ans;
    }
}
