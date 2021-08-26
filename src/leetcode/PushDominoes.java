package leetcode;

import java.util.Arrays;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] c = dominoes.toCharArray();
        int n = dominoes.length();
        int[] forces = new int[n];

        int forceRight = 0;
        int forceLeft = 0;
        for(int i = 0, j = n - 1; i < n; ++i, j--) {
            if(c[i] == 'R') forceRight = n;
            else if(c[i] == 'L') forceRight = 0;
            else forceRight = Math.max( forceRight - 1, 0);
            forces[i] += forceRight;
            if(c[j] == 'L') forceLeft = n;
            else if(c[j] == 'R') forceLeft = 0;
            else forceLeft = Math.max(forceLeft - 1, 0);
            forces[j] -= forceLeft;
        }
//        Arrays.stream(forces).forEach(x -> System.out.print(x + " "));
//        System.out.println();

        char[] ans = new char[n];
        for(int i = 0; i < n; ++i) ans[i] = forces[i] > 0 ? 'R' : forces[i] < 0 ? 'L' : '.';
        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(new PushDominoes().pushDominoes(".L.R...LR..L.."));
    }
}
