package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderTraversal(root, 0, ans);
        return ans;
    }

    public void levelOrderTraversal(TreeNode node, int level, List<List<Integer>> ans) {
        if(node == null) return;
        List<Integer> arr;
        try {
            arr = ans.get(level);
        } catch (Exception e) {
            ans.add(new ArrayList<>());
            arr = ans.get(level);
        }

        arr.add(node.val);
        levelOrderTraversal(node.left, level + 1, ans);
        levelOrderTraversal(node.right, level + 1, ans);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode tree2 = new TreeNode(1);
        TreeNode tree3 = new TreeNode();
        System.out.println(new LevelOrderTraversal().levelOrder(tree1));
        System.out.println(new LevelOrderTraversal().levelOrder(tree2));
        System.out.println(new LevelOrderTraversal().levelOrder(null));
    }
}
