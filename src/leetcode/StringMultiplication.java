package leetcode;

import java.util.*;

public class StringMultiplication {

    private String removePrefixZeros(String s) {
        int n = s.length();
        int i = 0;
        while(i < n) {
            if(s.charAt(i) != '0') break;
            i++;
        }
        String ans = s.substring(i);
        if(ans.equals("")) return "0";
        return ans;
    }

    public String multiply(String num1, String num2) {
        num1 = removePrefixZeros(num1);
        num2 = removePrefixZeros(num2);
        int m = num1.length();
        int n = num2.length();
        List<LinkedList<Integer>> muls = new LinkedList<>();
        int maxLength = 0;
        for(int i = n - 1; i >= 0; --i) { // 2nd number
            LinkedList<Integer> mul = new LinkedList<>();
            int carry = 0;
            for(int j = m - 1; j >= 0; --j) { // first number
                System.out.println(num2.charAt(i) + " x " + num1.charAt(j) + " = ");
                int num = ((num2.charAt(i) - '0') * (num1.charAt(j) -'0')) + carry;
                mul.addFirst(num % 10);
                carry = num / 10;
            }
            if(carry != 0) mul.addFirst(carry);
            for(int k = i; k < n - 1; ++k) mul.addLast(0);
            muls.add(new LinkedList<>(mul));
            maxLength = Math.max(maxLength, mul.size());
        }
        System.out.println(maxLength);
        for(LinkedList<Integer> mul: muls) {
            System.out.println(mul + " " + mul.size());
            int x = mul.size();
            for(int i = 0; i < maxLength - x; ++i) mul.addFirst(0);
            System.out.println(mul + " " + mul.size());
        }
        muls.forEach(System.out::println);
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for(int i = maxLength - 1; i >= 0; --i) {
            int sum = carry;
            for(LinkedList<Integer> mul: muls) {
                sum += mul.get(i);
            }
            ans.append((char)(sum % 10 + '0'));
            carry = sum / 10;
        }
        if(carry != 0) {
            ans.append(new StringBuilder(String.valueOf(carry)).reverse());
        }
    return removePrefixZeros(ans.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new StringMultiplication().multiply("123", "456"));
        System.out.println(new StringMultiplication().multiply("9133", "0"));
        System.out.println(new StringMultiplication().removePrefixZeros("000000"));
    }
}
