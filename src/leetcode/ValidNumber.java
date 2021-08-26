package leetcode;

import java.util.Arrays;

public class ValidNumber {

    private boolean isInteger(String s) {
        if(s.length() ==0) return false;
        if((s.charAt(0) == '+' || s.charAt(0) == '-') && s.length() == 1) return false;
        int start = s.charAt(0) == '+' || s.charAt(0) == '-' ? 1 : 0;
        for(int i = start;i <  s.length(); ++i){
            if('0' > s.charAt(i) || s.charAt(i) > '9') return false;
        }
        return true;
    }

    private boolean isFloat(String s) {
        if(s.length() == 0) return false;
        if(s.charAt(0) == '.' && s.length() == 1) return false;
        if((s.charAt(0) == '+' || s.charAt(0) == '-') && s.length() == 1) return false;
        if((s.charAt(0) == '+' || s.charAt(0) == '-') && s.charAt(1) == '.' && s.length() == 2) return false;

        int start = s.charAt(0) == '+' || s.charAt(0) == '-' ? 1 : 0;
        int dotCount = 0;
        for(int i = start; i < s.length(); ++i) {
            if(s.charAt(i) == '.') {
                dotCount++; continue;
            }
            if('0' > s.charAt(i) || s.charAt(i) > '9') return false;
        }
        return dotCount <= 1;

    }

    public boolean isNumber(String s) {
        s = s.toLowerCase();
        int eIndex = s.indexOf('e');
//        System.out.print("\n" + s + "-> ");
        if(eIndex != -1) {
            String[] sec = {s.substring(0, eIndex), s.substring(eIndex + 1)};
//            Arrays.stream(sec).forEach( a -> System.out.print(a + ", "));
            return isFloat(sec[0]) && isInteger(sec[1]);
        }
        return isFloat(s);
    }

    public static void main(String[] args) {
        ValidNumber ob = new ValidNumber();
        Arrays.stream(new String[]
                {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789",
                        "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", "e", "7e69e"})
                .map(s -> s + "  - > " + ob.isNumber(s)).forEach(s -> System.out.println(s));
    }
}
