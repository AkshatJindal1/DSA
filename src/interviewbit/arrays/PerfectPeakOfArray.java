package interviewbit.arrays;

import java.util.*;

public class PerfectPeakOfArray {
    public int perfectPeak(List<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = A.get(0);
        right[n - 1] = A.get(n - 1);
        for(int i = 1; i < n; ++i)
            left[i] = Math.max(left[i - 1], A.get(i));

        for(int i = n - 2; i >= 0; --i)
            right[i] = Math.min(right[i + 1], A.get(i));

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for(int i = 1; i < n - 1; ++i) if(left[i] != left[i - 1] && right[i] != right[i + 1]) return 1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectPeakOfArray().perfectPeak(Arrays.asList(5706, 26963, 24465, 29359, 16828, 26501, 28146, 18468, 9962, 2996, 492, 11479, 23282, 19170, 15725, 6335)));
    }
}
