package leetcode;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {

    int startPos;
    int endPos;

    public int[] searchRange(int[] nums, int target) {

        startPos = -1;
        endPos = -1;

        int start = 0;
        int end = nums.length - 1;
        search(nums, start, end, target);
        return new int[]{startPos, endPos};
    }

    private void search(int[] nums, int start, int end, int target) {
//        System.out.println(start);
//        System.out.println(end);
        if(start > end || start < 0 || end >= nums.length) return;
        if(nums[start] < target && nums[end] < target) return;
        if(nums[start] > target && nums[end] > target) return;

        int mid = start + (end - start) / 2;
//        System.out.println("mid = " + mid);
//        System.out.println();
        if(nums[mid] == target) {
            endPos = Math.max(endPos, mid);
            startPos = startPos == -1 ? mid : Math.min(startPos, mid);
            if(start == end) return;
            search(nums, start, mid - 1, target);
            search(nums, mid + 1, end, target);
        }
        if(start == end) return;
        if(nums[mid] > target)
            search(nums, start, mid - 1, target);
        if(nums[mid] < target)
            search(nums, mid + 1, end, target);
    }

    public static void main(String[] args) {
        Arrays.stream(new FirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).forEach(System.out::println);
    }
}
