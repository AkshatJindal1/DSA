package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, new LinkedList<>(), ans, 0);
        return ans;
    }

    public void solve(int[] candidates, int target, LinkedList<Integer> combination, List<List<Integer>> ans, int start) {
        if(target < 0) return;
        if(target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        int n = candidates.length;
        int last = 0;
        for(int i = start; i < n; ++i) {
            if(last == candidates[i]) continue;
            last = candidates[i];
            combination.addLast(candidates[i]);
            solve(candidates, target - candidates[i], combination, ans, i + 1);
            combination.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12},
        27));
    }
}
