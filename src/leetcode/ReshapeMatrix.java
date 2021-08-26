package leetcode;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rowCount = mat.length;
        int colCount = mat[0].length;
        if(rowCount * colCount != r * c) return mat;
        int[][] newMat = new int[r][c];
        int i = 0;
        int j = 0;
        for (int[] ints : mat)
            for (int l = 0; l < colCount; ++l) {
                newMat[i][j++] = ints[l];
                if (j == c) {
                    j = 0;
                    i++;
                }
            }
        return newMat;
    }

    public void printMatrix(int[][] mat) {
        for(int[] ints: mat) {
            for(int i: ints)
                System.out.print(i + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ReshapeMatrix ob = new ReshapeMatrix();
        ob.printMatrix(ob.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4));
    }
}
