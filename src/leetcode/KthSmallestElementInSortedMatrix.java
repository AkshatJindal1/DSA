package leetcode;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int smallestRow = 0;
        int smallestCol = 0;
        int[] smallestCols = new int[matrix.length];
        for(int j = 1; j <= k; ++j){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < matrix.length; ++i) {
                if(smallestCols[i] < matrix[0].length && matrix[i][smallestCols[i]] < min) {
                    minIndex = i;
                    min = matrix[i][smallestCols[i]];
                }
            }
            smallestCol = smallestCols[minIndex];
            smallestRow = minIndex;
            smallestCols[minIndex]++;
            System.out.println("K: " + (j) + ": Smallest row: " + smallestRow + " Smallest col: " + smallestCol + " Number: " + matrix[smallestRow][smallestCol]);
        }
        return matrix[smallestRow][smallestCol];
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,14,15}}, 8));
        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(new int[][]{{-5}}, 1));
        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(new int[][]{{1, 2},{1, 3}}, 3));
    }
}
