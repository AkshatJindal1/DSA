package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

    private int maximumAreaOfHistogram(int[] hist) {
        Stack<Integer> stack = new Stack<>();
        int maxArea =  -1;
        int area;
        int i = 0;
        int n = hist.length;
        while (i < n) {
            if(stack.isEmpty() || hist[stack.peek()] <= hist[i]) stack.add(i++);
            else {
                int top = stack.pop();
                if(stack.isEmpty()) area = hist[top] * i;
                else area = hist[top] * (i - stack.peek() - 1);
                if(area > maxArea) maxArea = area;
            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) area = hist[top] * i;
            else area = hist[top] * (i - stack.peek() - 1);
            if(area > maxArea) maxArea = area;
        }
        return maxArea;

    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[] hist = new int[c];
        for(int i = 0; i <  c; ++i) hist[i] = matrix[0][i] - '0';
        int ans = maximumAreaOfHistogram(hist);

        for(int i = 1; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                hist[j] = matrix[i][j] == '0' ? 0 : hist[j] + 1;
            }
            int area = maximumAreaOfHistogram(hist);
            if(area > ans) ans = area;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();
        System.out.println(mr.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
