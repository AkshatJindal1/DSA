package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        solve(root, targetSum, 0, new LinkedList<>());
        return ans;
    }

    private void solve(TreeNode node, int target, int sum, LinkedList<Integer> path) {
        if(node == null) return;
        path.add(node.val);
        if(node.left == null && node.right == null && sum + node.val == target) {
            if(sum + node.val == target)
                ans.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        solve(node.left, target, sum + node.val, path);
        solve(node.right, target, sum + node.val, path);
        path.removeLast();
    }

    public static void main(String[] args) {

    }
}
