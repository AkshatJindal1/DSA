package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int i = 2;
        for(int n = 2; n < nums.length; ++n) {
            if(nums[n] != nums[i - 2]) nums[i++] = nums[n];
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesInSortedArray2().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3,3,4}));
    }
}
