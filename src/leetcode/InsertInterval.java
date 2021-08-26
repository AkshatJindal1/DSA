package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();
        boolean flag = false;
        for(int[] interval: intervals) {
            if(!flag && interval[0] > newInterval[0]) {
                if(ans.isEmpty() || ans.getLast()[1] < newInterval[0]) ans.add(newInterval);
                else ans.getLast()[1] = Math.max(ans.getLast()[1], newInterval[1]);
                flag = true;
            }
            if(ans.isEmpty() || ans.getLast()[1] < interval[0]) ans.add(interval);
            else ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
        }

        if(!flag) {
            if(ans.isEmpty() || ans.getLast()[1] < newInterval[0]) ans.add(newInterval);
            else ans.getLast()[1] = Math.max(ans.getLast()[1], newInterval[1]);
            flag = true;
        }
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        Arrays.stream(ii.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})).forEach(i -> System.out.println("[" + i[0] + "," + i[1] + "]"));
    }
}
