package leetcode;

import java.util.*;

public class SetMatrixZeros {

    public void setZeroesMoreSpace(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                if(matrix[i][j] == 0) {
                    row.add(i); col.add(j);
                }

        for(int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                if(row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
    }

    public void setZeroesSpaceEff(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean isCol = false;
        // since first cell for both first row and col are same we need one addition variable to differentiate
        // here we ware using addition variable to see if first col needs to be set zero
        for(int i = 0; i < r; ++i) {
            if(matrix[i][0] == 0) isCol = true;

            for(int j = 1; j < c; ++j)
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
        }

        for(int i = 1; i < r; ++i) {
            for(int j = 1; j < c; ++j)
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
        }
        // first variable needs to be set zero
        if(matrix[0][0] == 0)
            for(int i = 1; i < c; ++i) matrix[0][i] = 0;
        if(isCol)
            for(int i = 0; i < r; ++i) matrix[i][0] = 0;
    }

    private void printMatrix(int[][] mat) {
        for(int[] row: mat) {
            for (int i : row)
                System.out.print(i + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new SetMatrixZeros().setZeroesSpaceEff(new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}});
    }
}
