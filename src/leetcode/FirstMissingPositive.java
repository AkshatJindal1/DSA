package leetcode;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // make all non positive as a large number so that we can ignore in later steps
        for(int i = 0; i < n; ++i) nums[i] = nums[i] <= 0 ? n + 1 : nums[i];

        for(int i = 0; i < n; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if(index < n && nums[index] > 0) nums[index] = -1 * nums[index];
        }

        for(int i = 0; i < n; ++i) if(nums[i] > 0) return i + 1;
        return n + 1;
    }
}
