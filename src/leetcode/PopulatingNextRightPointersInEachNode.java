package leetcode;

import java.util.*;

public class PopulatingNextRightPointersInEachNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    "}\n";
        }

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        Node levelPointer = new Node(Integer.MAX_VALUE);

        q.add(root);
        q.add(levelPointer);
        Node prev = null;
        while(!q.isEmpty()) {
//            System.out.println(q);
            Node top = q.poll();
            if(top.val == Integer.MAX_VALUE) {
//                if(prev != null) prev.next = null;
                prev = null;
                if(q.isEmpty()) break;
                q.add(levelPointer);
                continue;
            }
            if(prev != null) {
                prev.next = top;
            }
            prev = top;
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }
//        prev.next = null;
        return root;
    }

    public static void main(String[] args) {
        Node l1 = new Node(4);
        Node l2 = new Node(5);
        Node l3 = new Node(6);
        Node l4 = new Node(7);

        Node node1 = new Node(2, l1, l2, null);
        Node node2 = new Node(3, l3, l4, null);
        Node root = new Node(1, node1, node2, null);

        System.out.println(new PopulatingNextRightPointersInEachNode().connect(root));
    }
}
