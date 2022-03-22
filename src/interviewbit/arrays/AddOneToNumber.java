package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddOneToNumber {
    public static ArrayList<Integer> plusOne(List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int start;
        for(start = 0; start < n && A.get(start) == 0; start++){

        }
        int carry = 1;
        int i;
        for(i = n - 1; i >= start; --i) {
            int sum = A.get(i) + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            if(carry == 0) {
                i--;
                break;
            }
        }
        if(carry != 0) {
            ans.add(carry);
        }
        while(i >= start) ans.add(A.get(i--));
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(AddOneToNumber.plusOne(Arrays.asList(2, 5, 6, 8, 6, 1, 2, 4, 5)));
    }
}
