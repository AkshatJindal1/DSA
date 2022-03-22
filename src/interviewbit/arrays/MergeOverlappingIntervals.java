package interviewbit.arrays;

import java.util.*;

public class MergeOverlappingIntervals {

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

    public static ArrayList<Interval> merge(List<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(a -> a.start));
        ArrayList<Interval> ans = new ArrayList<>();
        Interval lastInterval = null;
        for(Interval interval : intervals) {
            if(lastInterval == null) lastInterval = interval;
            else{
                if(lastInterval.end >= interval.start) {
                    lastInterval.end = Math.max(lastInterval.end, interval.end);
                } else {
                    ans.add(lastInterval);
                    lastInterval = interval;
                }
            }
        }
        ans.add(lastInterval);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(MergeOverlappingIntervals.merge(Arrays.asList(new Interval(1,3),new Interval(2,6),new Interval(8,10),new Interval(15,18))));
    }
}
