package codechef;

import java.util.Scanner;

public class SecretRecipe {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int x3 = scanner.nextInt();
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            double d1 = Math.abs(x3 - x1);
            double d2 = Math.abs(x3 - x2);
            double t1 = d1 / v1;
            double t2 = d2 / v2;
            if(t1 < t2) System.out.println("Chef");
            else if(t1 > t2) System.out.println("Kefa");
            else System.out.println("Draw");

        }
    }
}
