package leetcode;
import java.util.*;

public class DegreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        int degree = 0;
        for(int c : count.values()) if(degree < c) degree = c;
        System.out.println("Degree: " + degree);
        int left = 0;
        int right = 0;
        int ans = nums.length;
        count = new HashMap<>();
        int subDegree = 0;
        int subDegreeNum = -1;
        while(left <= right && right < nums.length) {
            int x = nums[right];
            count.put(x, count.getOrDefault(x, 0) + 1);
            if(count.get(x) >= subDegree) {
                subDegree = count.get(x);
                subDegreeNum = x;
            }
            System.out.println(subDegreeNum + ": " + subDegree);
            if(subDegree == degree) {
                while(left <= right) {
                    int y = nums[left];
                    if(y == subDegreeNum){
                        System.out.println(left + " " + right);
                        ans = Math.min(ans, right - left + 1);
                        break;
                    }
                    count.put(y, count.get(y) - 1);
                    left++;
                }
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
        System.out.println(findShortestSubArray(new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2}));

        StringBuilder sb = new StringBuilder();
    }
}
