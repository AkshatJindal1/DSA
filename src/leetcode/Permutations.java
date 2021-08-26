package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, ans, new LinkedList<>());
        return ans;
    }

    private void permute(int [] nums, List<List<Integer>> ans, LinkedList<Integer> currList) {
        if(currList.size() == nums.length) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for(int i : nums) {
            if(currList.contains(i)) continue;
            currList.addLast(i);
            permute(nums, ans, currList);
            currList.removeLast();
        }
    }

    public static void main(String[] args) {
        Permutations ob = new Permutations();
        System.out.println(ob.permute(new int[]{}));
    }
}
