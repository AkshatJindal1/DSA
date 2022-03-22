package interviewbit.arrays;

import java.util.ArrayList;

public class MergeInterval {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        int start;
        ArrayList<Interval> ans = new ArrayList<>();
        for(start = 0; start < n; ++start) {
            if(newInterval.start <= intervals.get(start).start) break;
        }
        for(int i = 0; i < start - 1; ++i) {
            ans.add(intervals.get(i));
        }
        Interval lastInterval = newInterval;
        if(start > 0) {
            lastInterval = intervals.get(start - 1);
            if(lastInterval.end >= newInterval.start) {
                lastInterval.end = Math.max(lastInterval.end, newInterval.end);
            } else {
                ans.add(lastInterval);
                lastInterval = newInterval;
            }
        }
        for(int i = start; i < n; ++i) {
            Interval interval = intervals.get(i);
            if(lastInterval.end >= interval.start) {
                lastInterval.end = Math.max(lastInterval.end, interval.end);
            } else {
                ans.add(lastInterval);
                lastInterval = interval;
            }
        }
        ans.add(lastInterval);
        return ans;
    }
}
