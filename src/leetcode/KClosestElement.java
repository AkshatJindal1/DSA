package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KClosestElement {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        for(; i < arr.length; ++i)
            if(arr[i] > x) break;

        int left = i - 1;
        int right = i;

        List<Integer> ans = new ArrayList<>();
        while( left >=0 && right < arr.length) {
            int l = x - arr[left];
            int r = arr[right] - x;
            if(l <= r) {
                ans.add(arr[left--]);
            } else {
                ans.add(arr[right++]);
            }
            if (ans.size() == k) {
                Collections.sort(ans);
                return ans;
            }
        }
        if(left < 0) {
            for (int j = right; j < arr.length && ans.size() < k; ++j)
                ans.add(arr[j]);
            Collections.sort(ans);
            return ans;
        }

        for (int j = left; j >= 0 && ans.size() < k; --j)
            ans.add(arr[j]);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        KClosestElement ob = new KClosestElement();
        System.out.println(ob.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }
}
