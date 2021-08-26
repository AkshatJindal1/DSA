package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    int[] getNsl(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.add(i);
        }
        return ans;
    }

    int[] getNsr(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        for(int i = n - 1; i >= 0; --i) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();
            st.add(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nsl = getNsl(heights);
        int[] nsr = getNsr(heights);
//        printArray(heights);
//        printArray(nsl);
//        printArray(nsr);
        int ans = 0;

        for(int i = 0; i < heights.length; ++i) {
            int width = nsr[i] - nsl[i] - 1;
            int area = heights[i] * width;
            if(area > ans) ans = area;
        }
        return ans;
    }

    private void printArray(int[] arr) {
        for(int i: arr) System.out.print(i + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
