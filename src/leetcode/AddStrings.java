package leetcode;

public class AddStrings {

    StringBuilder sb;
    String num1, num2;
    public String addStrings(String num1, String num2) {
        sb = new StringBuilder();
        this.num1 = num1;
        this.num2 = num2;
        int carry = add(0, 0, num1.length(), num2.length());
        if(carry != 0) sb.append(carry);
        sb.reverse();
        return sb.toString();
    }


    private int add(int i, int j, int l1, int l2) {
        if(l1 == l2 && l1 == 0) return 0;
        int num;
        if(l1 == l2)
            num = num1.charAt(i) - '0' + num2.charAt(j) - '0' + add(i + 1, j + 1, l1 - 1, l2 - 1);
        else if(l1 > l2)
            num = num1.charAt(i) - '0' + add(i + 1, j, l1 - 1, l2);
        else
            num = num2.charAt(j) - '0' + add(i, j + 1, l1, l2 - 1);
        sb.append(num % 10);
        return num / 10;
    }
}
