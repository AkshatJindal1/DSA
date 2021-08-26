package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntegerToRoman {

    private void appendDigits(StringBuilder sb, char one, char five, char ten, short d) {
        if(d == 5) sb.append(five);
        else if(d == 4) sb.append(one).append(five);
        else if(d == 9) sb.append(one).append(ten);
        else if(d < 4) {
            char[] seq = new char[d];
            Arrays.fill(seq, one);
            sb.append(seq);
        }
        else if(d < 9) {
            char[] seq = new char[d - 5];
            Arrays.fill(seq,one );
            sb.append(five).append(seq);
        }
    }

    public String intToRoman(int num) {
        LinkedList<Short> digits = new LinkedList<>();
        int x = num;
        while(x != 0) {
            digits.addFirst((short) (x % 10));
            x /= 10;
        }
        System.out.println(digits);
        int n = digits.size();
        int m = n;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            short d = digits.get(m - n);
            System.out.println(d);
            if(n == 4) {
                char[] seq = new char[d];
                Arrays.fill(seq, 'M');
                sb.append(seq);
            }
            else if(n == 3) appendDigits(sb, 'C', 'D', 'M', d);
            else if(n == 2) appendDigits(sb, 'X', 'L', 'C', d);
            else if(n == 1) appendDigits(sb, 'I', 'V', 'X', d);
            n--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        System.out.println(itr.intToRoman(1994));
        System.out.println(itr.intToRoman(58));
    }
}
