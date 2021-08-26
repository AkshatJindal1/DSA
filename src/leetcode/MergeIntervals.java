package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        for(int[] interval: intervals) {
            if(ans.isEmpty() || ans.getLast()[1] < interval[0]) ans.add(interval);
            else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        return ans.toArray(new int[0][]);
    }
}
