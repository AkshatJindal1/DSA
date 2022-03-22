package geeksforgeeks;

import java.util.*;

public class Merge2BST {

    public List<Integer> merge(TreeNode tree1, TreeNode tree2) {
        Stack<TreeNode> stack1 = stackPushUtil(tree1, new Stack<>());
        Stack<TreeNode> stack2 = stackPushUtil(tree2, new Stack<>());

        List<Integer> ans = new ArrayList<>();

        while(!stack1.empty() && !stack2.isEmpty()) {
            if(stack1.peek().value < stack2.peek().value) {
                TreeNode node = stack1.pop();
                ans.add(node.value);
                stack1 = stackPushUtil(node.right, stack1);
            } else {
                TreeNode node = stack2.pop();
                ans.add(node.value);
                stack2 = stackPushUtil(node.right, stack2);
            }
        }

        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            ans.add(node.value);
            stack1 = stackPushUtil(node.right, stack1);
        }
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            ans.add(node.value);
            stack2 = stackPushUtil(node.right, stack2);
        }
        return ans;
    }

    public Stack<TreeNode> stackPushUtil(TreeNode root, Stack<TreeNode> stack) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        return stack;
    }


    public static void main(String[]args) {
        TreeNode root1 = null, root2 = null;

        /* Let us create the following tree as first tree
                3
            / \
            1 5
        */
        root1 = new TreeNode(3) ;
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);

        /* Let us create the following tree as second tree
                4
            / \
            2 6
        */
        root2 = new TreeNode(4) ;
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);

        // Print sorted nodes of both trees
        System.out.println(new Merge2BST().merge(root1, root2));
    }
}
