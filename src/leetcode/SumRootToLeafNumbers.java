package leetcode;

public class SumRootToLeafNumbers {
    int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        solve(root, 0);
        return ans;
    }

    private void solve(TreeNode node, int num) {
        System.out.println(num);
        if(node == null) return;
        if(node.left == null && node.right == null) {
            num = (num * 10) + node.val;
            System.out.println("Num to be added:" + num);
            System.out.println();
            ans += num;
            return;
        }
        solve(node.left, num * 10 + node.val);
        solve(node.right, num * 10 + node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
}
