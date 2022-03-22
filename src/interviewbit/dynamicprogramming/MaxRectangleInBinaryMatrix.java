package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix {

    int maxHist(int r, int c, List<Integer> row) {
        Stack<Integer> result = new Stack<>();
        int topVal;
        int maxArea = 0;
        int area;

        int i = 0;

        while(i < c) {
            if(result.empty() || row.get(result.peek()) <= row.get(i))
                result.push(i++);

            else {
                topVal = row.get(result.peek());
                result.pop();
                area = topVal * i;
                if (!result.isEmpty())
                    area = topVal * (i - result.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!result.empty()) {
            topVal = row.get(result.peek());
            result.pop();
            area = topVal * i;
            if (!result.empty())
                area = topVal * (i - result.peek() - 1);

            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int maximalRectangle(List<List<Integer>> A) {

        int R = A.size();
        int C = A.get(0).size();
        int result = maxHist(R, C, A.get(0));

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A.get(i).get(j) == 1)
                    A.get(i).set(j, A.get(i).get(j) + A.get(i - 1).get(j));

            // Update result if area with current row (as
            // last row of rectangle) is more
            result = Math.max(result, maxHist(R, C, A.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[][] val = {
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}};

        List<List<Integer>> input = new ArrayList<>();
        for (Integer[] ints : val) {
            input.add(Arrays.asList(ints));
        }
        System.out.println(new MaxRectangleInBinaryMatrix().maximalRectangle(input));

    }
}



