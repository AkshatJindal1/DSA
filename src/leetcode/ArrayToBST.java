package leetcode;

public class ArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int start, int end) {
        if(start < 0 || end < 0 || start == nums.length || end == nums.length || start > end) return null;
        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = createBST(nums, start, mid - 1);
        node.right = createBST(nums, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {

    }
}
