package geeksforgeeks;

public class CountBSTInRange {

    public int getCount(TreeNode root, int left, int right) {
        int count = 0;
        return countUtil(root, left, right, count);
    }

    public int countUtil(TreeNode node, int left, int right, int count) {
        if(node == null) return count;

        if(node.value < left) return countUtil(node.right, left, right, count);
        if(node.value > right) return countUtil(node.left, left, right, count);
        return countUtil(node.left, left, right, count) + countUtil(node.right, left, right, count) + 1;
    }

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(10);
        tree.left     = new TreeNode(5);
        tree.right     = new TreeNode(45);
        tree.left.left = new TreeNode(1);
        tree.right.left = new TreeNode(40);
        tree.right.right = new TreeNode(100);
        /* Let us constructed BST shown in above example
          10
        /    \
      5       45
     /       /  \
    1       40   100   */
        int l=5;
        int h=45;
        System.out.println("Count of nodes between [" + l + ", "
                + h+ "] is " + new CountBSTInRange().getCount(tree,
                l, h));
    }
}
