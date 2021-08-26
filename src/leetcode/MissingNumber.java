package leetcode;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        Long sum = Arrays.stream(nums).asLongStream().sum();
        int n = nums.length;
        Long totalSum = (long)n * (n + 1) / 2;
        return (int)(totalSum - sum);
    }
}
