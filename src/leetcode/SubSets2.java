package leetcode;

import java.util.*;

public class SubSets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        Arrays.sort(nums);
        for (int maskNumber=0; maskNumber<Math.pow(2,nums.length); maskNumber++){
            char[] mask = Integer.toBinaryString(maskNumber).toCharArray();
            List<Integer> subset = new ArrayList<>();
            int diff = nums.length-mask.length;
            for (int i = diff; i < nums.length; i++){
                if (mask[i-diff] == '1'){
                    subset.add(nums[i]);
                }
            }
            subsets.add(subset);
        }
        return new ArrayList<>(subsets);
    }

    public static void main(String[] args) {
        System.out.println(new SubSets2().subsetsWithDup(new int[]{0}));
    }
}
