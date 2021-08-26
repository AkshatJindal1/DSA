package codechef;

import java.util.Scanner;

public class MahaSena {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int oddCount = 0;
        int evenCount = 0;
        for(int i = 0; i < n; ++i) {
            if(scanner.nextInt() % 2 == 0) evenCount++;
            else oddCount++;
        }
        if(evenCount > oddCount) System.out.println("READY FOR BATTLE");
        else System.out.println("NOT READY");
    }
}
