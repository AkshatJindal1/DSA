package leetcode;

public class RecoverBST {

    TreeNode min;
    TreeNode previous;
    boolean found;

    public void recoverTree(TreeNode root) {
        min = new TreeNode(Integer.MAX_VALUE);
        previous = new TreeNode(Integer.MIN_VALUE);
        recoverBST(root);
        int temp = previous.val;
        previous.val = min.val;
        min.val = temp;
    }

    private void recoverBST(TreeNode root) {
        if(root == null || found) return;
        recoverBST(root.left);
        if(root.val < previous.val && root.val < min.val) {
            min = root;
            found = true;
        } else if(!found) {
            previous = root;
        }
        recoverBST(root.right);
    }
}
