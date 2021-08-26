package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int l = nums.length;

        for(int i = 0; i < l - 2; ++i) {
            int j = i + 1;
            int k = l - 1;
            if( i > 0 && nums[i] == nums[i - 1]) continue;
            while( j < k) {
                if(k < l - 1 && nums[k] == nums[k + 1]) {
                    k--; continue;
                }
                if(nums[i] + nums[j] + nums[k] > 0) k--;
                else if(nums[i] + nums[j] + nums[k] < 0) j++;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
