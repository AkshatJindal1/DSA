package geeksforgeeks;

public class ReplaceSurroundedOWithX {

    public static void main (String[] args) {

        ReplaceSurroundedOWithX ob = new ReplaceSurroundedOWithX();
        char[][] mat = {
                {'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}};

        ob.replaceSurrounded(mat);

        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");

            System.out.println("");
        }
    }



    private void replaceSurrounded(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m ; ++i)
            for (int j = 0; j < n; ++j) if(mat[i][j] == 'O') mat[i][j] = '-';

        //    final all corner '-' to to turn back to 'O'
        for(int i = 0; i < m; ++i) {
            if(mat[i][0] == '-') findCorners(mat, i, 0, '-', 'O');
        }
        for(int i = 0; i < m; ++i) {
            if(mat[i][n - 1] == '-') findCorners(mat, i, n - 1, '-', 'O');
        }
        for(int i = 0; i < n; ++i)
            if(mat[0][i] == '-') findCorners(mat, 0, i, '-', 'O');
        for(int i = 0; i < n; ++i)
            if(mat[m -1][i] == '-') findCorners(mat, m - 1, i, '-', 'O');

        for(int i = 0; i < m ; ++i)
            for (int j = 0; j < n; ++j) if(mat[i][j] == '-') mat[i][j] = 'X';
    }

    private void findCorners(char[][] mat, int i, int j, char prev, char curr) {
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length) return;
        if(mat[i][j] != prev) return;
        mat[i][j] = curr;
        findCorners(mat, i + 1, j, prev, curr);
        findCorners(mat, i - 1, j, prev, curr);
        findCorners(mat, i, j + 1, prev, curr);
        findCorners(mat, i, j - 1, prev, curr);
    }


}
