package leetcode;

import java.util.*;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : arr) count.put(n, count.getOrDefault(n, 0) + 1);

        for(int n: arr) {
            if(count.get(n) == 0) continue;
            if(n < 0) {
                if(n % 2 != 0 || count.getOrDefault(n / 2, 0) <= 0) return false;
                count.put(n , count.get(n) - 1);
                count.put(n / 2, count.get(n / 2) - 1);
            } else {
                if(count.getOrDefault(n * 2, 0) <= 0) return false;
                count.put(n , count.get(n) - 1);
                count.put(n * 2, count.get(n * 2) - 1);
            }
        }
        return true;
    }
}
