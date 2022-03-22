package geeksforgeeks;

import java.util.Arrays;

public class RomateMatrix {

    private static void displayMatrix(
            int N, int mat[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                        " " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        int N = 4;

        // Test Case 1
        int mat[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        rotateMatrix2(N, mat);

        displayMatrix(N, mat);
    }

    private static void rotateMatrix(int n, int[][] mat) {
        if(n <= 1) return;
        int start = 0;
        while(n > 1) {
            for(int i = 0; i < n - 1; ++i) {
                int temp1 = mat[start + i][start];
                int temp2 = mat[start + n - 1][start + i];
                int temp3 = mat[start + n - 1 - i][start + n - 1];
                int temp4 = mat[start][start + n - 1 - i];

                mat[start + i][start] = temp4;
                mat[start + n - 1][start + i] = temp1;
                mat[start + n - 1 - i][start + n - 1] = temp2;
                mat[start][start + n - 1 - i] = temp3;
            }
            n -= 2;
            ++start;
        }
    }

    private static void rotateMatrix2(int n, int[][] mat) {
        for(int[] row: mat) {
            for(int i = 0; i < n / 2; ++i) {
                int temp = row[i];
                row[i] = row[n - i - 1];
                row[n - i - 1] = temp;
            }
        }
        displayMatrix(n, mat);
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
//                System.out.printf("i: %d, j: %d, %d, %d\n", i, j, mat[i][j], mat[j][i]);
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}
