package geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

    static class Tree {
        int data;
        Tree left;
        Tree right;
        Tree nextRight;

        Tree(int data) {
            this.data = data;
        }
    }

    public void connect(Tree root) {
        Tree levelMarker = new Tree(Integer.MAX_VALUE);
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        queue.add(levelMarker);
        Tree temp = levelMarker;
        while(!queue.isEmpty()) {
            Tree prev = temp;
            temp = queue.poll();
            if(prev == temp) break;
            if(temp.equals(levelMarker)) {
                prev.nextRight = null;
                queue.add(levelMarker);
                continue;
            }
            if(!prev.equals(levelMarker))
                prev.nextRight = temp;
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
    }

    public void connect1(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        Tree temp = null;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; ++i) {
                Tree prev = temp;
                temp = queue.poll();
                if(i > 0) prev.nextRight = temp;
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            temp.nextRight = null;
        }
    }

    public static void main(String args[])
    {
        Tree tree = new Tree(10);

        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
        tree.left = new Tree(8);
        tree.right = new Tree(2);
        tree.left.left = new Tree(3);

        // Populates nextRight pointer in all nodes
        new ConnectNodesAtSameLevel().connect1(tree);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                + "the tree"
                + "(-1 is printed if there is no nextRight)");
        int a = tree.nextRight != null ? tree.nextRight.data : -1;
        System.out.println("nextRight of " + tree.data + " is "
                + a);
        int b = tree.left.nextRight != null ? tree.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.left.data + " is "
                + b);
        int c = tree.right.nextRight != null ? tree.right.nextRight.data : -1;
        System.out.println("nextRight of " + tree.right.data + " is "
                + c);
        int d = tree.left.left.nextRight != null ? tree.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.left.left.data + " is "
                + d);
    }
}
