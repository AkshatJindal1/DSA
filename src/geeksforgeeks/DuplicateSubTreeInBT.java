package geeksforgeeks;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DuplicateSubTreeInBT {

     Set<String > subTrees;

     /*
     * return: root = null => "$"
     *         duplicate sub tree found ""
     *         duplicate subTree not found tree string
     * */
     private String duplicateTreeUtil(TreeNode root) {
         if(root == null) return "$";

         String leftString = duplicateTreeUtil(root.left);
         if(leftString.equals("")) return leftString;
         String  rightString = duplicateTreeUtil(root.right);
         if(rightString.equals("")) return rightString;
          String s = "" + leftString + rightString;

          if(s.length() > 0 && subTrees.contains(s)) return "";
          subTrees.add(s);
          return s;
     }

     public boolean hasDuplicateSubTree(TreeNode tree) {
         subTrees = new HashSet<>();
         return duplicateTreeUtil(tree).equals("");
     }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');
        root.right.right = new TreeNode('B');
        root.right.right.right = new TreeNode('E');
        root.right.right.left= new TreeNode('D');
        System.out.println(new DuplicateSubTreeInBT().hasDuplicateSubTree(root));

     }
}
