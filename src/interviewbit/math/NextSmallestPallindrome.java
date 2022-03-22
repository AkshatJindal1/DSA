package interviewbit.math;

import java.util.Arrays;

public class NextSmallestPallindrome {

    private boolean isAll9(String A) {
        for(char c : A.toCharArray()) {
            if(c != '9') return false;
        }
        return true;
    }

    public String solve(String A) {
        int[] num = new int[A.length()];
        int index = 0;
        for(char c : A.toCharArray()) {
            num[index++] = c - '0';
        }
        if (isAll9(A)) {
            char[] ans = new char[A.length() + 1];
            Arrays.fill(ans, '0');
            ans[0] = '1'; ans[A.length()] = '1';
            return new String(ans);
        }

        return solveUtil(num);
    }

    public String solveUtil(int[] num) {
        int n = num.length;
        int mid = n / 2;
        int i = mid - 1;
        int j = n % 2 == 0 ? mid : mid + 1;

        boolean flag = false;

        while(i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }
        if(i < 0 || num[i] < num[j]) flag = true;

        while(i >= 0) {
            num[j++] = num[i--];
        }
        if(flag) {
            int carry = 1;
            if(n % 2 == 1) {
                num[mid] += 1;
                carry = num[mid] / 10;
                num[mid] %= 10;
            }
            i = mid - 1;
            j = n % 2 == 0 ? mid : mid + 1;
            while(i >= 0 && carry > 0) {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i];
                i--;
                j++;
            }
        }
        char[] ans = new char[num.length];
        int index = 0;
        for(int x : num) {
            ans[index++] = (char)(x + '0');
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(new NextSmallestPallindrome().solve("61423221"));
        System.out.println(new NextSmallestPallindrome().solve("999"));
    }
}
