import java.util.*;

public class SizeOfDisconnectedComponents {

    static class TreeNode {
        int val;
        List<TreeNode> children;
        int treeSize;

        TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
            treeSize = 1;
        }
    }

    TreeNode tree;
    Map<Integer, TreeNode> cache;

    private void createTree(int[][] edges) {
        cache = new HashMap<>();
        if(edges.length == 0) return;
        tree = new TreeNode(edges[0][0]);
        cache.put(edges[0][0], tree);

        for(int[] edge : edges) {
            if(!cache.containsKey(edge[0])) {
                cache.put(edge[0], new TreeNode(edge[0]));
            }
            if(!cache.containsKey(edge[1])) {
                cache.put(edge[1], new TreeNode(edge[1]));
            }
            cache.get(edge[0]).children.add(cache.get(edge[1]));
        }
    }

    private void getTreeSizes(TreeNode node) {
        if(node == null) return;
        if(node.children.size() == 0) return; // leaf node
        node.children.forEach(this::getTreeSizes);
        node.treeSize += node.children.stream().map(x -> x.treeSize).mapToInt(Integer::intValue).sum();
    }

    private int[] connectedComponentSize(int[] edge) {
        int t1 = cache.get(edge[0]).treeSize;
        int t2 = cache.get(edge[1]).treeSize;
        int min = Math.min(t1, t2);
        return new int[]{min, cache.size() - min};
    }

    int smallTreeSize = 0;
    private int[] treeCutSize(int[] edge) {
        return new int[]{connectedComponentSizeSingle(edge, tree), smallTreeSize};
    }
    private int connectedComponentSizeSingle(int[] edge, TreeNode node) {
        if(node == null) return 0;
        int treeSize = 1;
        for(TreeNode child : node.children) {
            int subTreeSize = connectedComponentSizeSingle(edge, child);
            if(child.val == edge[1] || child.val == edge[0]) smallTreeSize = subTreeSize;
            else treeSize += subTreeSize;
        }
        return treeSize;
    }

    public static void main(String[] args) {
        SizeOfDisconnectedComponents ob = new SizeOfDisconnectedComponents();
        ob.createTree(new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {5, 9}});
        ob.getTreeSizes(ob.tree);

//        ob.cache.forEach((key, value) -> System.out.println(key + " " + value.treeSize));
//        System.out.println(ob.cache.get(0).treeSize);

        System.out.println(Arrays.toString(ob.connectedComponentSize(new int[]{0, 2})));
        System.out.println(Arrays.toString(ob.treeCutSize(new int[]{0, 2})));
    }


}
