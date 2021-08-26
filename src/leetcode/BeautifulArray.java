package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {

    Map<Integer, int[]> dp;

    public int[] beautifulArray(int n) {
        dp = new HashMap<>();
        return recurse(n);
    }

    public int[] recurse(int n) {
        if(dp.containsKey(n)) return dp.get(n);
        int[] ans = new int[n];
        if(n == 1){
            ans[0] = 1;
        } else {
            int t = 0;
            for(int i: recurse((n + 1) / 2))
                ans[t++] = 2 * i - 1;
            for(int i: recurse(n / 2))
                ans[t++] = 2 * i;
        }
        dp.put(n, ans);
        return ans;
    }
}
