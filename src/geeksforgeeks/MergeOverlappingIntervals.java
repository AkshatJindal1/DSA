package geeksforgeeks;

import java.util.*;

public class MergeOverlappingIntervals {

    static class Interval
    {
        int start,end;
        Interval(int start, int end)
        {
            this.start=start;
            this.end=end;
        }

        @Override
        public String toString() {
            return "( " + start + ", " + end + " )";
        }
    }

    List<Interval> mergeIntervals(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x.start));
        List<Interval> ans = new ArrayList<>();
        Interval lastInterval = null;
        for(Interval interval: intervals) {
            if(lastInterval == null) lastInterval = interval;
            else {
                if(lastInterval.end > interval.start) {
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

    public static void main(String args[]) {
        Interval[] arr=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        System.out.println(new MergeOverlappingIntervals().mergeIntervals(arr));
    }
}
