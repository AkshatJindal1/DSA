package leetcode;

import java.util.Arrays;

public class MeetingRoom3 {
    /**
     * @param intervals: the intervals
     * @param rooms: the sum of rooms
     * @param ask: the ask
     * @return: true or false of each meeting
     */
    static int[] sum = new int[50];
    static int[] vis = new int[50];

    public static boolean[] meetingRoomIII(int[][] intervals, int rooms, int[][] ask) {
        // Write your code here.
        int length = ask.length;
        boolean[] ans = new boolean[length];
        sum[0] = 0;
        int maxn = 0;
        int i;
        for (i = 0; i < intervals.length; i++) {
            vis[intervals[i][0]]++;
            vis[intervals[i][1]]--;
            maxn = Math.max(maxn, intervals[i][1]);
        }
        System.out.println(Arrays.toString(vis));
        for (i = 0; i < ask.length; i++) {
            maxn = Math.max(maxn, ask[i][1]);
        }
        System.out.println(maxn);
        int tmp = 0;
        for (i = 1; i <= maxn; i++) {
            tmp += vis[i];
            if (tmp < rooms) {
                sum[i] = 0;
            } else {
                sum[i] = 1;
            }
        }
        System.out.println(Arrays.toString(sum));
        for (i = 1; i <= maxn; i++) sum[i] += sum[i - 1];
        System.out.println(Arrays.toString(sum));
        for (i = 0; i < ask.length; i++) {
            if (sum[ask[i][0] - 1] == sum[ask[i][1] - 1]) {
                ans[i] = true;
            } else ans[i] = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(meetingRoomIII(new int[][]{{1, 2}, {4, 5}, {8, 10}}, 1, new int[][]{{4, 5}, {5, 6}})));
    }
}
