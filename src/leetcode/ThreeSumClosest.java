package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int ans = 0;
        int l = nums.length;

        for(int i = 0; i < l - 2; ++i) {
            int j = i + 1;
            int k = l - 1;
            if( i > 0 && nums[i] == nums[i - 1]) continue;
            while(j < k) {
                if(k < l - 1 && nums[k] == nums[k + 1]) {
                    k--; continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                int d = Math.abs(sum - target);
                if(d < diff) {
                    diff = d;
                    ans = sum;
                }
                if(sum >= target) k--;
                else j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0,0,0}, 1));
    }
}
