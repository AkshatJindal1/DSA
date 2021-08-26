package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountBits {

    private int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
        return arr;
    }

    public int[] countBitsSlow(int n) {
        if(n == 0) return new int[]{0};
        if(n == 1) return new int[]{1};
        List<Integer> list = new ArrayList<>(); list.add(0); list.add(1);
        List<Integer> lastGroupList = new ArrayList<>(); lastGroupList.add(1);
        int i = 1;
        while(i < n) {
            for(int x: lastGroupList) {
                list.add(x);
                if(++i >= n) return listToArray(list);
            }
            for(int x: lastGroupList) {
                list.add(x + 1);
                if(++i >= n) return listToArray(list);
            }
            int l = lastGroupList.size();
            for(int j = 0; j < l; ++j) lastGroupList.add(lastGroupList.get(j) + 1);
        }
        return listToArray(list);
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for(int i = 1; i <= n; ++i) {
            if(i % 2 == 0) ans[i] = ans[ i / 2];
            else ans[i] = ans[ i / 2] + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(new CountBits().countBitsSlow(5)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(new CountBits().countBits(5)).forEach(System.out::print);
    }
}
