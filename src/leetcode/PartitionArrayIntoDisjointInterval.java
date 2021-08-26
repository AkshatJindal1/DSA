package leetcode;

import java.util.Arrays;

public class PartitionArrayIntoDisjointInterval {

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] forwardMax = new int[n];
        int[] backwardMin = new int[n];

        forwardMax[0] = nums[0];
        backwardMin[n - 1] = nums[n - 1];

        for(int i = 1; i < n; ++i) {
            forwardMax[i] = Math.max(forwardMax[i - 1], nums[i]);
            backwardMin[n - i - 1] = Math.min(backwardMin[n - i], nums[n - i - 1]);
        }

        Arrays.stream(forwardMax).forEach(x -> System.out.print(x + "\t"));
        System.out.println();
        Arrays.stream(backwardMin).forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        for(int i = 0; i < n - 1; ++i) {
            if(forwardMax[i] <= backwardMin[i + 1]) return i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionArrayIntoDisjointInterval().partitionDisjoint(new int[]{1,1,1,0,6,12}));
        System.out.println(new PartitionArrayIntoDisjointInterval().partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(new PartitionArrayIntoDisjointInterval().partitionDisjoint(new int[]{2,2,2,0,6,1,12,14,7}));
    }
}
