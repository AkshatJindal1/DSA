package leetcode;

import java.util.*;

public class ReduceArraySizeToHalf {

    class Pair {
        int key;
        int value;

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class PqComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p2.value, p1.value);
        }
    }

    public int minSetSize(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PqComparator());
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }
        for(Map.Entry<Integer, Integer> x : map.entrySet()) {
            pq.add(new Pair(x.getKey(), x.getValue()));
        }
        int ans = 0;
        int currLength = 0;
        while(!pq.isEmpty() && currLength < n / 2) {
            Pair p = pq.poll();
            currLength += p.value;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ReduceArraySizeToHalf().minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }
}
