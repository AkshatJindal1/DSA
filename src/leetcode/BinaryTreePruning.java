package leetcode;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if(hasAllZero(root)) return null;
        return root;
    }

    private boolean hasAllZero(TreeNode node) {
        if(node == null) return true;
        boolean leftPrune = hasAllZero(node.left);
        boolean rightPrune = hasAllZero(node.right);
        if(leftPrune) node.left = null;
        if(rightPrune) node.right = null;
        return node.val == 0 && leftPrune && rightPrune;
    }

    public static void main(String[] args) {
        BinaryTreePruning btp = new BinaryTreePruning();

    }
}
