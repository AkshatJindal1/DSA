package leetcode;

public class PeakElement {

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        while( start <= end) {
            mid = (start + end) / 2;
            if(mid > 0 && nums[mid] > nums[mid - 1] && mid < n - 1 && nums[mid] > nums[mid + 1]) return mid;
            if(mid == 0 && mid < n - 1 && nums[mid] > nums[mid + 1]) return mid;
            if(mid == n - 1 && mid > 0 && nums[mid] > nums[mid - 1]) return mid;
            if(mid == 0 && mid < n - 1 && nums[mid] < nums[mid + 1]) start = mid + 1;
            else if(mid == n - 1 && mid > 0 && nums[mid] < nums[mid - 1]) end = mid - 1;
            else if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) start = mid + 1;
            else end = mid - 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2}));
        System.out.println(findPeakElement(new int[]{1}));
    }
}
