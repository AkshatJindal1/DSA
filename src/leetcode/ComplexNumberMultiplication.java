package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String num1, String num2) {
        int i1 = num1.indexOf('+');
        int i2 = num2.indexOf('+');
        int r1 = Integer.parseInt(num1.substring(0, i1));
        int c1 = Integer.parseInt(num1.substring(i1 + 1, num1.length() - 1));
        int r2 = Integer.parseInt(num2.substring(0, i2));
        int c2 = Integer.parseInt(num2.substring(i2 + 1, num2.length() - 1));
        int a = r1 * r2 - c1 * c2;
        int b = r1 * c2 + r2 * c1;
        StringBuilder sb = new StringBuilder();
        return sb.append(a).append("+").append(b).append("i").toString();
    }

    public static void main(String[] args) {
        ComplexNumberMultiplication cnm = new ComplexNumberMultiplication();
        System.out.println(cnm.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
