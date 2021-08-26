package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KSum {

    private List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        if(start == nums.length || nums[start] * k > target || nums[nums.length - 1] * k < target)
            return ans;
        if(k == 2) return twoSum(nums, target, start);
        for(int i = start; i < nums.length; ++i) {
            if(i == start || nums[i] != nums[i - 1])
                for(List<Integer> subAns : kSum(nums, target - nums[i], k - 1, i + 1)) {
                    List<Integer> sub = new ArrayList<>(Collections.singletonList(nums[i]));
                    sub.addAll(subAns);
                    ans.add(sub);
                }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        int low = start; int high = nums.length - 1;
        while(low < high) {
            int sum = nums[low] + nums[high];
            if(sum < target || (low > start && nums[low] == nums[low - 1])) low++;
            else if(sum > target || (high < nums.length - 1 && nums[high] == nums[high + 1])) high--;
            else ans.add(Arrays.asList(nums[low++], nums[high--]));
        }
        return ans;
    }

    public List<List<Integer>> fourSum(int [] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    public static void main(String[] args) {
        KSum ob = new KSum();
        System.out.println(ob.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
}
