package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestThreeSum {

    public static Integer closestThreeSum(int[] nums, int target) {
        Arrays.sort(nums);
        int l = nums.length;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < l - 2; ++i) {
            int j = i + 1;
            int k = l - 1;
            if( i > 0 && nums[i] == nums[i - 1]) continue;
            while( j < k) {
                if(k < l - 1 && nums[k] == nums[k + 1]) {
                    k--; continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum - target) < Math.abs(diff))
                    diff = target - sum;
                if(sum < target) j++; else k--;
            }
        }
        return target - diff;
    }

    public static void main(String[] args) {

    }
}
