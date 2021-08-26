package leetcode;

import java.util.*;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int n: nums) {
            counter.putIfAbsent(n, 0);
            counter.put(n , counter.get(n) + 1);
        }
        System.out.println(counter);
        LinkedList<Integer> per = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(per, nums.length, counter, ans);
        System.out.println(ans);
        return ans;

    }


    private void solve(LinkedList<Integer> per, int n, Map<Integer, Integer> counter, List<List<Integer>> ans) {
        if(per.size() == n) {
            System.out.println(per);
            ans.add(new ArrayList<>(per));
            System.out.println(ans);
            return;
            
        }
        for(Map.Entry<Integer, Integer> entry: counter.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count == 0) continue;
            per.addLast(num);
            counter.put(num, count - 1);
            solve(per, n, counter, ans);
            per.removeLast();
            counter.put(num, count);
        }
    }

    protected void backtrack(LinkedList<Integer> comb, Integer N, Map<Integer, Integer> counter, List<List<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        System.out.println(p.permuteUnique(new int[]{1, 1, 2}));
    }
}
