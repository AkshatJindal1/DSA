package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while(!queue.isEmpty()) {
            Node head = queue.poll();
            if(head == null) {
                if(level.size() > 0) {
                    ans.add(new ArrayList<>(level));
                    level = new ArrayList<>();
                    queue.add(null);
                    continue;
                } else break;
            }
            level.add(head.val);
            queue.addAll(head.children);
        }
        return ans;
    }
}
