package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxConsequitiveOnes {

    public static int longestOnes(int[] nums, int k) {
        int ans = 0;
        int start = 0;
        Deque<Integer> dq = new LinkedList<>();
        for(int end = 0; end < nums.length; ++end) {
            if(nums[end] == 0) dq.add(end);
            if(dq.size() > k) {
                start = dq.pop() + 1;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 1, 1}, 1));
    }
}
