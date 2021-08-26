package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) list.add(null);
        else if(start == end) list.add(new TreeNode(start));
        else if(start + 1 == end) {
            list.add(new TreeNode(start, null, new TreeNode(end)));
            list.add(new TreeNode(end, new TreeNode(start), null));
        } else {
            for(int i = start; i <= end; ++i) {
                List<TreeNode> leftSubTrees = generate(start, i - 1);
                List<TreeNode> rightSubTrees = generate(i + 1, end);
                for(TreeNode left : leftSubTrees)
                    for(TreeNode right: rightSubTrees)
                        list.add(new TreeNode(i, left, right));
            }
        }
        return list;
    }
}
