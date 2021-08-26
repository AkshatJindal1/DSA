package leetcode;

public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int tot = m * n;

        int start = 0;
        int end = tot - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
