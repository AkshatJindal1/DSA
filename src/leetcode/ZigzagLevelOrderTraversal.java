package leetcode;

import java.util.*;

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int level = queue.size();
            Integer[] arr = new Integer[level];
            for(int i = 0; i < level; ++i) {
                TreeNode node = queue.poll();
                if(leftToRight) arr[i] = node.val;
                else arr[level - 1 - i] = node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(new ArrayList<>(Arrays.asList(arr)));
            leftToRight = !leftToRight;
        }
        return ans;

    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode tree2 = new TreeNode(1);
        TreeNode tree3 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        System.out.println(new ZigzagLevelOrderTraversal().zigzagLevelOrder(tree1));
        System.out.println(new ZigzagLevelOrderTraversal().zigzagLevelOrder(tree2));
        System.out.println(new ZigzagLevelOrderTraversal().zigzagLevelOrder(null));
        System.out.println(new ZigzagLevelOrderTraversal().zigzagLevelOrder(tree3));
    }
}
