package leetcode;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleArray {
    int[] nums;
    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = nums.length;
        int[] nums = this.nums.clone();
        Random random = ThreadLocalRandom.current();
        for (int i = n - 1; i > 0; --i) {
            int index = random.nextInt(i + 1);
            int a = nums[index];
            nums[index] = nums[i];
            nums[i] = a;
        }
        return nums;
    }
}
