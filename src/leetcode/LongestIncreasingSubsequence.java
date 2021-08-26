package leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class LongestIncreasingSubsequence {
    private static final Logger LOGGER = Logger.getLogger("Test");
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j)
                if (nums[i] > nums[j]) lis[i] = Math.max(lis[i], lis[j] + 1);
            ans = Math.max(ans, lis[i]);
        }
        return ans;
    }

    public static int lengthOfLISFast(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] tails = new int[n];
        tails[0] = nums[0];
        int length = 1;
        for(int i = 1; i < n; ++i) {
            if(nums[i] > tails[length - 1]) tails[length++] = nums[i];
            else {
                int idx = Arrays.binarySearch(tails, 0, length - 1, nums[i]);
                if( idx < 0) idx = -1 * idx - 1;
                tails[idx] = nums[i];
            }
        }
        return length;
    }


    public static void main(String[] args) {
//        LOGGER.info(() -> lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}) + "");
//        LOGGER.info(() ->lengthOfLISFast(new int[]{7, 7, 7, 7, 7, 7, 7}) + "");
//        long start = System.nanoTime();
//        LOGGER.log(Level.INFO, "{0}", lengthOfLIS(new int[]{ 2, 5, 3, 7, 11, 8, 10, 13, 6 }));
//        long end = System.nanoTime();
//        LOGGER.log(Level.INFO, "Time taken in normal: {0} ns", end - start);
//        start = System.nanoTime();
//        LOGGER.info(() ->lengthOfLISFast(new int[]{ 2, 5, 3, 7, 11, 8, 10, 13, 6 }) + "");
//        end = System.nanoTime();
//        LOGGER.log(Level.INFO, "Time taken in fast algo: {0} ns", end - start);

        List<Long> ordinate = new ArrayList<>();
        List<Long> abscissa = new ArrayList<>();
        long i = 10l;
        while(i <= 10000L) {
            long t = i;
            List<Integer> list = new ArrayList<>();
            while(t-- > 0) {
                list.add(ThreadLocalRandom.current().nextInt(10000));
            }
            int[] arr = new int[list.size()];
            for(int j = 0; j < list.size(); ++j) arr[j] = list.get(j);
            long time = 0L;
            for(int k = 0; k < 10; ++k) {
                long start = System.nanoTime();
//                lengthOfLIS(arr);
                System.out.println(list.size() + " " + lengthOfLISFast(arr));
                long end = System.nanoTime();
                time += (end - start);
            }

            abscissa.add(time / 10);
            ordinate.add(i);
            i += 100;
        }

        SwingUtilities.invokeLater(() -> GraphPlotter.printGraph(abscissa, ordinate));
    }
}
