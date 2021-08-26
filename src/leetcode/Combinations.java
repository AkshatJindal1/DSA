package leetcode;

import java.util.*;

public class Combinations {

    int n;
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        ans = new ArrayList<>();
        solve(0, k, new LinkedList<>());
        return ans;
    }

    private void solve(int i, int k, LinkedList<Integer> list) {
        if(k == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }
        for(int j = i + 1; j <= n - k + 1; ++j) {
            list.add(j);
            solve(j, k - 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
        System.out.println(new Combinations().combine(1, 1));
    }
}
