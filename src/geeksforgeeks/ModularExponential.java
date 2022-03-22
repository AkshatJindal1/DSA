package geeksforgeeks;

public class ModularExponential {

    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        int p = 13;
        System.out.print("Power is " + power(x, y, p));
    }

    /* Iterative Function to calculate (x^y) in O(log y) */
//    (a*b) % c = ((a % c) * (b % c)) % c
    private static int power(int x, int y, int p) {
        int ans = 1;
        x = x % p;
        if(x == 0) return 0;
        while(y > 0) {
            if(y % 2 == 1) ans = (ans * x) % p;
            y = y / 2;
            x = (x * x) % p;
        }
        return ans;
    }
}
